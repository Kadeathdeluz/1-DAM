package uf12addressapp.models;

import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Contact {

    private SimpleStringProperty nom;
    private SimpleStringProperty cognoms;
    private SimpleStringProperty domicili;
    private SimpleStringProperty ciutat;
    private SimpleIntegerProperty codi_postal;
    private SimpleObjectProperty<LocalDate> data_de_naixement;

    public Contact(String nom, String cognoms, String domicili, String ciutat, int cp, int dia, int mes, int any) {
        this.nom = new SimpleStringProperty(nom);
        this.cognoms = new SimpleStringProperty(cognoms);
        this.domicili = new SimpleStringProperty(domicili);
        this.ciutat = new SimpleStringProperty(ciutat);
        this.codi_postal = new SimpleIntegerProperty(cp);
        this.data_de_naixement = new SimpleObjectProperty<>(LocalDate.of(any, mes, dia));
    }

    public Contact() {
        this.nom = new SimpleStringProperty("");
        this.cognoms = new SimpleStringProperty("");
        this.domicili = new SimpleStringProperty("");
        this.ciutat = new SimpleStringProperty("");
        this.codi_postal = new SimpleIntegerProperty(-1);
        this.data_de_naixement = new SimpleObjectProperty<>(null);
    }
    
    public SimpleStringProperty getNom() {
        return nom;
    }


    public void setNom(SimpleStringProperty nom) {
        this.nom = nom;
    }

    public SimpleStringProperty getCognoms() {
        return cognoms;
    }

 
    public void setCognoms(SimpleStringProperty cognoms) {
        this.cognoms = cognoms;
    }


    public SimpleStringProperty getDomicili() {
        return domicili;
    }


    public void setDomicili(SimpleStringProperty domicili) {
        this.domicili = domicili;
    }


    public SimpleStringProperty getCiutat() {
        return ciutat;
    }

 
    public void setCiutat(SimpleStringProperty ciutat) {
        this.ciutat = ciutat;
    }


    public SimpleIntegerProperty getCodi_postal() {
        return codi_postal;
    }


    public void setCodi_postal(SimpleIntegerProperty codi_postal) {
        this.codi_postal = codi_postal;
    }

 
    public SimpleObjectProperty<LocalDate> getData_de_naixement() {
        return data_de_naixement;
    }

 
    public void setData_de_naixement(SimpleObjectProperty<LocalDate> data_de_naixement) {
        this.data_de_naixement = data_de_naixement;
    }

}
