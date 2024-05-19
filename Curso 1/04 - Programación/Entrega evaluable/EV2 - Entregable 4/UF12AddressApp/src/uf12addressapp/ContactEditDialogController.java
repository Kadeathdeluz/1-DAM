package uf12addressapp;

import java.net.URL;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uf12addressapp.models.Contact;

/**
 * FXML Controller class
 *
 * @author Roldán Sanchis Martínez
 */
public class ContactEditDialogController implements Initializable {

    //Variables de la vista de edició/creació
    @FXML
    private TextField nom_textfield;
    @FXML
    private TextField cognoms_textfield;
    @FXML
    private TextField domicili_textfield;
    @FXML
    private TextField ciutat_textfield;
    @FXML
    private TextField codi_postal_textfield;
    @FXML
    private TextField data_de_naixement_textfield;

    //Variables de la clase
    private Stage dialogStage;
    private boolean acceptClicked = false;
    private Contact contacte;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * Modifica l'objecte dialogStage
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Retorna el valor de acceptClicked
     *
     * @return
     */
    public boolean getAcceptClicked() {
        return this.acceptClicked;
    }

    /**
     * Carrega les dades del contacte a la nova vista
     *
     * @param contacte
     */
    public void loadContacte(Contact contacte) {
        this.contacte = contacte;
        if (contacte != null) {
            this.nom_textfield.setText(contacte.getNom().get());
            this.cognoms_textfield.setText(contacte.getCognoms().get());
            this.domicili_textfield.setText(contacte.getDomicili().get());
            this.ciutat_textfield.setText(contacte.getCiutat().get());
            this.codi_postal_textfield.setText(Integer.toString(contacte.getCodi_postal().get()));
            this.data_de_naixement_textfield.setText(DateUtil.format(contacte.getData_de_naixement().get()));

        } else {
            this.nom_textfield.setText("");
            this.cognoms_textfield.setText("");
            this.domicili_textfield.setText("");
            this.ciutat_textfield.setText("");
            this.codi_postal_textfield.setText("");
            this.data_de_naixement_textfield.setText("");
        }
    }

    /**
     * Tanca el quadre de diàleg sense guardar.
     */
    @FXML
    public void cancel() {
        this.dialogStage.close();
    }

    /**
     * Tanca el quadre de diàleg guardant els canvis.
     */
    @FXML
    public void ok() {
        //Comprova els TextField 
        if (areFormInputsValid()) {
            //Actualitza els valors del contacte amb els dels camps
            this.contacte.setNom(new SimpleStringProperty(nom_textfield.getText()));
            this.contacte.setCognoms(new SimpleStringProperty(cognoms_textfield.getText()));
            this.contacte.setDomicili(new SimpleStringProperty(domicili_textfield.getText()));
            this.contacte.setCiutat(new SimpleStringProperty(ciutat_textfield.getText()));
            this.contacte.setCodi_postal(new SimpleIntegerProperty(Integer.parseInt(codi_postal_textfield.getText())));
            this.contacte.setData_de_naixement(new SimpleObjectProperty<>(DateUtil.parse(data_de_naixement_textfield.getText())));

            //acceptClicked a true i tanca el diàleg
            this.acceptClicked = true;
            this.dialogStage.close();
        }
    }

    /**
     * Comprova que els camps tinguen els valors corresponents per a poder
     * donar-li a OK
     */
    private boolean areFormInputsValid() {
        //Missatge d'error que anirà acumulant els errors que trobe
        String missatge = "";
        //Utilitze una variable per a cada TextField
        String nom = nom_textfield.getText(),
                cognoms = cognoms_textfield.getText(),
                domicili = domicili_textfield.getText(),
                ciutat = ciutat_textfield.getText(),
                codi = codi_postal_textfield.getText(),
                data = data_de_naixement_textfield.getText();

        //Comprova el camp nom
        if (nom == null
                || nom.isBlank()) {
            missatge += "Nom no vàlid.";
        }
        //Comprova el camp cognoms
        if (cognoms == null
                || cognoms.isBlank()) {
            missatge += "\nCognoms no vàlids.";
        }
        //Comprova el camp domicili
        if (domicili == null
                || domicili.isBlank()) {
            missatge += "\nDomicili no vàlid.";
        }
        //Comprova el camp ciutat
        if (ciutat == null
                || ciutat.isBlank()) {
            missatge += "\nCiutat no vàlida.";
        }
        //Comprova el camp codi postal 
        if (codi == null
                || codi.isBlank()) {
            missatge += "\nCodi postal no vàlid.";
        } else {
            //Comprova que siga un int (tipus correcte de data)
            try {
                //Si al convertir de String a Integer salta l'excepció, no és un int (tipus incorrecte)
                //El codi postal no pot ser negatiu
                if(Integer.parseInt(codi) < 0) {
                    missatge += "\nCodi postal no vàlid.";
                }
            } catch (NumberFormatException nfe) {
                //Si no és un int
                missatge += "\nCodi postal no vàlid.";
            }
        }
        //Comprova el camp data de naixement
        if (data == null
                || data.isBlank()
                || !DateUtil.validDate(data)) {
            //Comprovem també que siga una data vàlida
            missatge += "\nData de Naixement no vàlida.";
        }
        //Si no hi ha cap error retorna true
        if (missatge.isEmpty()) {
            return true;
        } else {
            //En cas que hi haja errors, mostra una alerta amb el missatge d'error corresponent
            Alert alert;

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Camps incorrectes");
            alert.setContentText(missatge);
            alert.showAndWait();

            //I finalment retorna false
            return false;
        }
    }
}
