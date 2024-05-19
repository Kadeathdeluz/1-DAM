package uf12addressapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import uf12addressapp.models.Contact;

import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class UF12AddressApp extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<Contact> contactes = FXCollections.observableArrayList();

    //Constructor de prova
    public UF12AddressApp() {
        this.contactes.add(new Contact("Guillermo", "Garrido Portes", "C/Albacete", "Valencia", 47001, 11, 01, 1995));
        this.contactes.add(new Contact("Maria", "Gómez Gil", "C/Alzira", "Alacant", 47002, 21, 02, 2000));
        this.contactes.add(new Contact("Diego", "Gonzalez Cuenca", "C/Manises", "Castello", 47003, 31, 03, 2005));
        this.contactes.add(new Contact("Laura", "Galiana Gutiérrez", "C/Xativa", "Barcelona", 47004, 01, 04, 2010));
        this.contactes.add(new Contact("Silvia", "Gandia García", "Plaza de la Reina", "Valencia", 47005, 12, 05, 2015));
    }
    
    public ObservableList<Contact> getContactes() {
        return this.contactes;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        //Asignem el primaryStage al stage inicial
        this.primaryStage = stage;
        //Canviem el títol
        this.primaryStage.setTitle("Activitat Avaluable 4 - Roldán Sanchis");

        //Establim l'icona de l'aplicació
        Image icona = new Image("resources/images/contacts.png");
        this.primaryStage.getIcons().add(icona);

        //Inicialitzem la Scene principal
        initRootLayout();

        //shoIndex inicialitza la Scene interna
        showIndex();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void initRootLayout() {
        try {
            //Carguem el FXML
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("views/RootLayout.fxml"));
            this.rootLayout = loader.load();
            //Creem una Scene amb l'arxiu FXML
            Scene scene = new Scene(this.rootLayout);
            //Assignem la Scene al Stage
            this.primaryStage.setScene(scene);

            // Creem el controlador per a poder assignar-li una instància de UF12AddressApp
            RootLayoutController controller = loader.getController();
            controller.setUF12AddressApp(this);

            //Mostrem el Stage
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void showIndex() {
        try {
            //Carguem el FXML
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("views/Index.fxml"));
            AnchorPane index = (AnchorPane) loader.load();
            this.rootLayout.setCenter(index);
            
            IndexController controller = loader.getController();
            controller.setUF12AddressApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setContactFilePath(File arxiu) {
        Preferences prefs = Preferences.userNodeForPackage(getClass());
        if (arxiu != null) {
            prefs.put("ruta_arxiu", arxiu.getPath());
        } else {
            prefs.remove("ruta_arxiu");
        }
    }
    
    public File getContactFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(getClass());
        String ruta_arxiu = prefs.get("ruta_arxiu", null);
        if (ruta_arxiu != null) {
            return new File(ruta_arxiu);
        } else {
            return null;
        }
    }
    
    public Window getPrimaryStage() {
        return this.primaryStage;
    }
    
    public void saveContactDataToFile(File arxiu) {
        try {
            FileWriter fitxer = new FileWriter(arxiu);
            fitxer.write("");
            fitxer.close();
            fitxer = new FileWriter(arxiu, true);
            for (Contact contact : this.contactes) {
                String str = contact.getNom().get() + ","
                        + contact.getCognoms().get() + ","
                        + contact.getDomicili().get() + ","
                        + contact.getCiutat().get() + ","
                        + String.valueOf(contact.getCodi_postal().get()) + ","
                        + DateUtil.format(contact.getData_de_naixement().get());
                fitxer.write(str);
                fitxer.write(System.lineSeparator());
            }
            fitxer.close();
            this.setContactFilePath(arxiu);
        } catch (Exception ex) {
            System.err.println("Error al guardar els contactes en l'arxiu: " + arxiu.getName());
        }
    }
    
    public void loadContactDataFromFile(File arxiu) {
        this.contactes.clear();
        try {
            FileReader fr = new FileReader(arxiu);
            BufferedReader br = new BufferedReader(fr);
            //Lectura del fitxer
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] contacte = linea.split(",");
                String[] fecha = contacte[5].split("\\.");
                this.contactes.add(new Contact(
                        contacte[0],
                        contacte[1],
                        contacte[2],
                        contacte[3],
                        Integer.parseInt(contacte[4]),
                        Integer.parseInt(fecha[0]),
                        Integer.parseInt(fecha[1]),
                        Integer.parseInt(fecha[2])
                ));
            }
            fr.close();
            this.setContactFilePath(arxiu);
        } catch (Exception ex) {
            System.err.println("No s'ha trobat l'arxiu: " + arxiu.getName());
        }
    }
    
    public boolean showContactEditDialog(Contact contacte) {
        try {
            //Carreguem el FXML
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("views/ContactEditDialog.fxml"));
            
            AnchorPane index = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            
            if (contacte.getNom().get().isEmpty()) {
                dialogStage.setTitle("Nou contacte");
            } else {
                dialogStage.setTitle("Editar " + contacte.getNom().get() + " " + contacte.getCognoms().get());
            }
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            
            Scene scene = new Scene(index);
            dialogStage.setScene(scene);
            
            ContactEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.loadContacte(contacte);
            
            dialogStage.showAndWait();
            
            return controller.getAcceptClicked();
            
        } catch (IOException e) {
            return false;
        }
    }
    
}
