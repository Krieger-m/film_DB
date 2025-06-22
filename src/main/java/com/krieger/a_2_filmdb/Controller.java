package com.krieger.a_2_filmdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.SQLException;


public class Controller {

    public MySQL mySQL = new MySQL();




    @FXML private Button add_btn;   @FXML private Button test_btn;
    @FXML private Button delete_btn;

    @FXML private TextField bonusFeatures_textField;    @FXML private TextField genre_textField;
    @FXML private TextField lagerort_textField; @FXML private TextField spieldauer_textField;
    @FXML private TextField titel_textField;    @FXML private TextField suche_textField;

    @FXML private ListView<String> list_view;

    @FXML private Label notification_lbl;

    @FXML private VBox textField_container;



    @FXML
    void onAdd_btnClick()  {
        String titel = titel_textField.getText();
        String lagerort = lagerort_textField.getText();
        int spieldauer = Integer.parseInt(spieldauer_textField.getText());
        String bonusFeatures = bonusFeatures_textField.getText();
        String genre = genre_textField.getText();

        if (titel.isEmpty() || lagerort.isEmpty()) {
            notification_lbl.setText("Bitte füllen Sie alle Felder aus.");
            return;
        }
        mySQL.addFilm(titel,lagerort,spieldauer,bonusFeatures,genre);

        clearAllTextFields();
    }

    @FXML
    void onDelete_btnClick(ActionEvent event) {
        String selectedFilm = list_view.getSelectionModel().getSelectedItem();
        if (selectedFilm != null) {
            String[] parts = selectedFilm.split("\n");

            for(String part : parts){System.out.println("\tpart"+part);}

            int filmId = Integer.parseInt(parts[0].split(": ")[1]);

            System.out.println("id: "+filmId);

            mySQL.deleteFilm(filmId);
            list_view.refresh();
//            list_view.getItems().remove(selectedFilm);
            notification_lbl.setText("Film erfolgreich gelöscht.");
        } else {
            notification_lbl.setText("Bitte wählen Sie einen Film zum Löschen aus oder geben Sie Titel oder die ID " +
                    "ein.");
        }
    }

    @FXML
    void onSearch_btnClick()  {
        if (suche_textField.getText().isEmpty()) {
            try{
                mySQL.showAllFilms();
                list_view.setItems( mySQL.getFilmList());
            }catch(SQLException err){
                notification_lbl.setText("// Fehler bei der SQL-Abfrage : " + err);
                System.out.println("\n\t\t// Controller.onSearchButtonClicked() - Fehler bei der SQL-Abfrage : " + err);
            }
        }

    }

    private void clearAllTextFields(){
        for (Node node : textField_container.getChildren()) {
//            System.out.println("\t\t- "+node.getClass().getSimpleName() + " " + String.valueOf(node instanceof TextField ));
            if (node instanceof TextField) {
                ((TextField) node).clear();
                System.out.println("\t\t\t- "+node.getId() + " wurde geleert");
            }
        }
    }
}
