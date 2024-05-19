package uf12addressapp;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Roldán Sanchis Martínez
 */
public class RootLayoutController implements Initializable {

    private UF12AddressApp uf12address_app;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * S'obte, desde la clase principal.
     *
     * @param uf12address_app
     */
    public void setUF12AddressApp(UF12AddressApp uf12address_app) {
        this.uf12address_app = uf12address_app;
    }

    /**
     * Tanca l'aplicació
     */
    @FXML
    public void exit() {
        System.exit(0);
    }

    /**
     *
     */
    @FXML
    public void openFile() {
        File arxiu = this.mostraDialeg("open");
        //Si s'ha obtingut el nom de un arxiu
        if (arxiu != null) {
            this.uf12address_app.loadContactDataFromFile(arxiu);
        }
    }

    /**
     * Es guarda en l'arxiu l'observableList que existeix o crida a saveAsFile()
     */
    @FXML
    public void saveFile() {
        File arxiu = this.uf12address_app.getContactFilePath();
        if (arxiu != null) {
            this.uf12address_app.saveContactDataToFile(arxiu);
        } else {
            this.saveAsFile();
        }
    }

    /**
     * Es mostra l'explorador per a posar-li nom a l'arxiu i el guarda.
     */
    @FXML
    public void saveAsFile() {
        File arxiu = this.mostraDialeg("save");
        //Si s'ha obtingut el nom i ruta d'un arxiu
        if (arxiu != null) {
            //Asegurem la extensió per si l'usuari ha pogut evitar el filtre
            if (!arxiu.getPath().endsWith(".txt")) {
                //Creem l'arxiu amb l'extensió ".txt"
                arxiu = new File(arxiu.getPath() + ".txt");
            }
            this.uf12address_app.saveContactDataToFile(arxiu);
        }
    }

    public File mostraDialeg(String tipus) {
        File arxiu;
        //Classe per a poder seleccionar l'arxiu desde l'explorador
        FileChooser seleccionador = new FileChooser();
        //Filtre per a evitar que es seleccionen arxius d'extensions no permeses
        FileChooser.ExtensionFilter extensio = new FileChooser.ExtensionFilter("Archivos de texto", "*.txt");
        //Afegim al seleccionador la restricció de l'extensió
        seleccionador.getExtensionFilters().add(extensio);
        //Mostrem l'explorador am un dialog que apareixerà sobre primary_stage
        if (tipus.equals("save")) {
            //Si el tipus es "save" obri l'explorador per a guardar
            return arxiu = seleccionador.showSaveDialog(uf12address_app.getPrimaryStage());
        } else {
        }
        //Si el tipus és diferent a "save" obri l'explorador per a seleccionar l'arxiu
        return arxiu = seleccionador.showOpenDialog(uf12address_app.getPrimaryStage());
    }

    /**
     * Mostra informació sobre l'autor en un alert de tipus informatiu
     */
    @FXML
    public void sobreMi() {
        Alert alert;
        
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sobre mi");
        alert.setHeaderText("Informació de l'autor");
        alert.setContentText("Nom i cognom: Roldán Sanchis");
        alert.showAndWait();
    }

}
