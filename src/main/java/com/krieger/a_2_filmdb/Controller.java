package com.krieger.a_2_filmdb;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.sql.SQLException;


public class Controller {

    public MySQL mySQL = new MySQL();




    @FXML private Button add_btn;   @FXML private Button test_btn;
    @FXML private Button delete_btn;

    @FXML private TextField bonusFeatures_textField;    @FXML private TextField genre_textField;
    @FXML private TextField lagerort_textField; @FXML private TextField spieldauer_textField;
    @FXML private TextField titel_textField;    @FXML private TextField suche_textField;

    @FXML private ListView<String> list_view;

    @FXML private Label notification_label;

    @FXML private VBox textField_container;


    @FXML
    public void initialize() {
        try {
            mySQL.showAllFilms();
            list_view.setItems(mySQL.getFilmList());
        } catch (SQLException err) {
            setNotificationError("Fehler bei der SQL-Abfrage: " + err.getMessage());
            System.out.println("\n\t\t// Controller.initialize() - Fehler bei der SQL-Abfrage : \n\t" + err.getMessage());
        }
    }


    @FXML
    void onAdd_btnClick()  {
        String titel = titel_textField.getText();
        String lagerort = lagerort_textField.getText();

        if (titel.isEmpty() || lagerort.isEmpty()) {
            setNotificationError("Bitte Titel und Lagerort eingeben.");
            return;
        } else {
            int spieldauer = Integer.parseInt(spieldauer_textField.getText());
            String bonusFeatures = bonusFeatures_textField.getText();
            String genre = genre_textField.getText();

            mySQL.addFilm(titel,lagerort,spieldauer,bonusFeatures,genre);
            setNotificationSuccess("Film erfolgreich hinzugefügt.");

            clearAllTextFields();
        }
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
            setNotificationSuccess("Film erfolgreich gelöscht.");
        } else {
            setNotificationError("Bitte wählen Sie einen Film zum Löschen aus\noder geben Sie Titel oder die ID ein.");
        }
    }

    @FXML
    void onSearch_btnClick()  {
        if (suche_textField.getText().isEmpty()) {
            try{
                mySQL.showAllFilms();
                list_view.setItems( mySQL.getFilmList());
            }catch(SQLException err){
                setNotificationError("Fehler bei der SQL-Abfrage: " + err.getMessage());
                System.out.println("\n\t\t// Controller.onSearchButtonClicked() - Fehler bei der SQL-Abfrage : \n\t" + err.getMessage());
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

    private void setNotificationError(String message) {
        notification_label.setText(message);
        notification_label.setStyle("-fx-text-fill: #e06c75;");
        hideNotificationAfterDelay();
    }
    private void setNotificationSuccess(String message) {
        notification_label.setText(message);
        notification_label.setStyle("-fx-text-fill: #98c379;");
        hideNotificationAfterDelay();
    }

    private void hideNotificationAfterDelay() {
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(event -> notification_label.setText(""));
        pause.play();
    }


}
