package uf12addressapp;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import uf12addressapp.models.Contact;

/**
 * FXML Controller class
 *
 * @author Roldán Sanchis Martínez
 */
public class IndexController implements Initializable {

    //Variables de la tabla
    @FXML
    private TableView<Contact> contact_table;
    @FXML
    private TableColumn<Contact, String> nom_column;
    @FXML
    private TableColumn<Contact, String> cognoms_column;
    //Variables de la vista de detalls
    @FXML
    private Label nom_label;
    @FXML
    private Label cognoms_label;
    @FXML
    private Label domicili_label;
    @FXML
    private Label ciutat_label;
    @FXML
    private Label codi_postal_label;
    @FXML
    private Label data_de_naixement_label;

    //Variable per a la classe principal
    private UF12AddressApp uf12address_app;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom_column.setCellValueFactory(cellData -> cellData.getValue().getNom());
        cognoms_column.setCellValueFactory(cellData -> cellData.getValue().getCognoms());

        //Al carregar la vista esborrem les dades
        showContactDetails(null);

        /**/
        contact_table.getSelectionModel().selectedItemProperty().addListener((observbable, old_value, new_value) -> showContactDetails(new_value));
    }

    /**
     * Obté, desde la classe principal, l'array de contactes.
     *
     * @param uf12address_app
     */
    public void setUF12AddressApp(UF12AddressApp uf12address_app) {
        this.uf12address_app = uf12address_app;
        contact_table.setItems(uf12address_app.getContactes());
    }

    public void showContactDetails(Contact contacte) {
        if (contacte != null) {
            this.nom_label.setText(contacte.getNom().get());
            this.cognoms_label.setText(contacte.getCognoms().get());
            this.domicili_label.setText(contacte.getDomicili().get());
            this.ciutat_label.setText(contacte.getCiutat().get());
            this.codi_postal_label.setText(Integer.toString(contacte.getCodi_postal().get()));
            this.data_de_naixement_label.setText(DateUtil.format(contacte.getData_de_naixement().get()));

        } else {
            this.nom_label.setText("");
            this.cognoms_label.setText("");
            this.domicili_label.setText("");
            this.ciutat_label.setText("");
            this.codi_postal_label.setText("");
            this.data_de_naixement_label.setText("");
        }
    }

    /**
     * Elimina un item de la taula de contactes.
     */
    @FXML
    public void deleteContact() {
        Alert alert;
        int selected_index = contact_table.getSelectionModel().getSelectedIndex();

        if (!contact_table.getItems().isEmpty() && selected_index != -1) {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar l'esborrat");
            alert.setHeaderText("Aquesta acció és irreversible");
            alert.setContentText("Estàs segur que vols esborrar aquest contacte?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                contact_table.getItems().remove(selected_index);
            }

        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No hi ha cap element seleccionat");
            alert.setContentText("Has de seleccionar un contacte abans d'esborrar");
            alert.showAndWait();
        }
    }

    /**
     * Crea un nou contacte buit.
     */
    @FXML
    public void newContact() {
        Contact tempContact = new Contact();
        boolean acceptClicked = uf12address_app.showContactEditDialog(tempContact);
       
        //Si el botó aceptar es polsa, afig el contacte
        if (acceptClicked) {
            uf12address_app.getContactes().add(tempContact);
        }

    }
    
    /**
     * Edita el contacte seleccionat.
     */
    @FXML
    public void editContact() {
        Contact selectedContact = contact_table.getSelectionModel().getSelectedItem();
        
        //En cas de no ser null, mostra l'edició de contacte i asigna el valor retornat a acceptClicked
        if(selectedContact != null) {
            boolean acceptClicked = uf12address_app.showContactEditDialog(selectedContact);
            //En cas que acceptClicked siga true, mostra els detalls del contacte
            if(acceptClicked) {
                showContactDetails(selectedContact);
            }
        }
        //En cas de que selectedContact siga null, mostrar un missatge d'error
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            
            alert.setTitle("Error");
            alert.setHeaderText("No hi ha cap element seleccionat");
            alert.setContentText("Has de seleccionar un contacte abans d'editar");
            alert.showAndWait();
        }
    }

}
