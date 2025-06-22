package com.krieger.a_2_filmdb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL {

    private Connection connection = null;
    private Statement statement =null;
    private ResultSet rs = null;
    private PreparedStatement preparedStatement = null;
    private final String connectionString = "jdbc:mysql://127.0.0.1:3306/film_db";


    public MySQL() {

    }


    private List<String> filmList = new ArrayList<String>();


    public ObservableList<String> getFilmList() {
        return FXCollections.observableArrayList(filmList);
    }

    public void establishConnection() throws SQLException  {
        try {

            this.connection = DriverManager.getConnection(this.connectionString, "root", "");

            System.out.println("\n\t- Verbindung erfolgreich hergestellt!");

            this.statement = this.connection.createStatement();
        }
        catch (SQLException e) {
            System.out.println("\n\t\t// Fehler bei der Verbindung");
            throw e;
        }
    }


    public void showFilmsContaining(String s) throws SQLException {
        try {
            establishConnection();
            String query = "SELECT * FROM film WHERE Titel LIKE ? OR Lagerort LIKE ? OR Genre LIKE ? OR BonusFeatures LIKE ?;";
            this.preparedStatement = this.connection.prepareStatement(query);
            this.preparedStatement.setString(1,"%"+s+"%");
            this.preparedStatement.setString(2,"%"+s+"%");
            this.preparedStatement.setString(3,"%"+s+"%");
            this.preparedStatement.setString(4,"%"+s+"%");

            updateFilmList();
        } catch (SQLException e) {
            System.out.println("\n\t\t// Fehler bei der SQL-Abfrage: " + e);
            throw e;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    closeConnection();
                } catch (SQLException e) {
                    System.out.println("\n\t\t// Fehler beim Schließen des ResultSet: " + e);
                }
            }
        }
    }

    public void updateFilmList()throws SQLException{
        rs = statement.executeQuery("select * from film");
        filmList.clear();
        while (rs.next()){
            String sb = "ID: "+rs.getInt(1)+
                    "\n\t\tTitel:\t\t\t\t"+rs.getString("Titel") +
                    "\n\t\tLagerort:\t\t\t"+rs.getString("Lagerort") +
                    "\n\t\tSpieldauer:\t\t"+rs.getInt("Spieldauer") +
                    "\n\t\tBonus Features:\t"+rs.getString("BonusFeatures") +
                    "\n\t\tGenre:\t\t\t"+rs.getString("Genre")+"\n";
            System.out.println("\t-> " + sb.split("\n")[0]+" "+sb.split("\n")[1]);
            filmList.add(sb);
        }
    }

    public void showAllFilms() throws SQLException {
        try {
            establishConnection();
            updateFilmList();
        }catch (SQLException e) {
            System.out.println("\n\t\t// Fehler bei der SQL-Abfrage: " + e);
            throw e;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    closeConnection();
                } catch (SQLException e) {
                    System.out.println("\n\t\t// Fehler beim Schließen des ResultSet: " + e);
                }
            }
        }
    }

    public void addFilm(String titel, String lagerort, int spieldauer, String bonusFeatures, String genre) {
        try {

            establishConnection();
            String query = "INSERT INTO film (Titel, Lagerort, Spieldauer, BonusFeatures, Genre) VALUES (?, ?, ?, ?, ?)";
            this.preparedStatement = this.connection.prepareStatement(query);
            this.preparedStatement.setString(1, titel);
            this.preparedStatement.setString(2, lagerort);
            this.preparedStatement.setInt(3, spieldauer);
            this.preparedStatement.setString(4, bonusFeatures);
            this.preparedStatement.setString(5, genre);
            this.preparedStatement.executeUpdate();
            System.out.println("\n\t- Film erfolgreich hinzugefügt!");
            updateFilmList();
        } catch (SQLException e) {
            System.out.println("\n\t\t// Fehler beim Hinzufügen des Films: " + e);
        } finally {
            closeConnection();
        }
    }

    public void deleteFilm(String titel){

        try {
            establishConnection();

            String query = "DELETE FROM film WHERE Titel LIKE ?";
            this.preparedStatement = this.connection.prepareStatement(query);
            this.preparedStatement.setString(1, "%"+titel+"%");

            int rowsAffected = this.preparedStatement.executeUpdate();
            updateFilmList();
            if (rowsAffected > 0) {
                System.out.println("\n\t- Film erfolgreich gelöscht!");

            } else {
                System.out.println("\n\t- Kein Film mit der angegebenen Titel gefunden.");
            }
        } catch (SQLException e) {
            System.out.println("\n\t\t// Fehler beim Löschen des Films: " + e);
        } finally {
            closeConnection();
        }
    }

    public void deleteFilm(int id){

        try {
            establishConnection();

            String query = "DELETE FROM film WHERE ID = ?";
            this.preparedStatement = this.connection.prepareStatement(query);
            this.preparedStatement.setInt(1, id);
            int rowsAffected = this.preparedStatement.executeUpdate();
            updateFilmList();
            if (rowsAffected > 0) {
                System.out.println("\n\t- Film erfolgreich gelöscht!");

            } else {
                System.out.println("\n\t- Kein Film mit der angegebenen ID gefunden.");
            }
        } catch (SQLException e) {
            System.out.println("\n\t\t// Fehler beim Löschen des Films: " + e);
        } finally {
            closeConnection();
        }
    }

    public void closeConnection(){
        if (connection != null) {
            try {
                connection.close();
                System.out.println("\n\t- Verbindung erfolgreich geschlossen!");
            } catch (SQLException e) {
                System.out.println("\n\t\t// Fehler beim Schließen der Verbindung: " + e);
            }
        }
    }




}



