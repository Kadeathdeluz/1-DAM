package Ampliacio;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Aparcament {

    private int placesLliures, placesOcupades;
    private Plaça[] places;
    private int proximaPlaça;

    public Aparcament() {
        this.placesLliures = 20;
        this.placesOcupades = 0;
        this.places = new Plaça[20];
        //Creamos todas las plazas con número fijo de plaza, libre y sin matrícula asignada
        for (int i = 0; i < places.length; i++) {
            places[i] = new Plaça(i + 1, Estat.LLIURE, null);
        }
        //Al crear el aparcamiento, la primera plaza que asignaremos es la 1 (index = 0)
        proximaPlaça = 0;
    }

    public int getPlacesLliures() {
        return placesLliures;
    }

    public void setPlacesLliures(int placesLliures) {
        this.placesLliures = placesLliures;
    }

    public int getPlacesOcupades() {
        return placesOcupades;
    }

    public void setPlacesOcupades(int placesOcupades) {
        this.placesOcupades = placesOcupades;
    }

    public Plaça[] getPlaces() {
        return places;
    }

    public void setPlaces(Plaça[] places) {
        this.places = places;
    }

    public void aparcar(int index, String matricula) {
        places[index].setEstat(Estat.OCUPADA);
        places[index].setMatricula(matricula);

        placesOcupades++;
        placesLliures--;
    }

    public void deixarPlaça(int index) {
        places[index].setEstat(Estat.LLIURE);
        places[index].setMatricula(null);
        
        placesOcupades--;
        placesLliures++;
    }

    public void entrar(String matricula) {
        if (placesOcupades < 20 && placesLliures > 0) {
            System.out.println("Vaja a la plaça número " + (proximaPlaça + 1));
            aparcar(proximaPlaça, matricula);
            actualizarProximaPlaça();
        } else {
            System.out.println("No queden places lliures");
        }
    }

    public void eixir(int index) {
        if (placesOcupades > 0 && placesLliures < 20) {
            System.out.println("Fins aviat, " + places[index].getMatricula() + "!");
            deixarPlaça(index);
            //Al quedarse libre, pasa a ser la siguiente en ocuparse 
            proximaPlaça = index;
        } else {
            System.out.println("No queden cotxes a l'aparcament");
        }
    }

    public void estatPlaça(int numPlaça) {
        Plaça plaça = places[numPlaça - 1];
        System.out.println(plaça.toString());
    }

    public boolean validaMatricula(String matricula) {
        return matricula.matches("[0-9]{4}[A-Z]{3}");
    }

    private void actualizarProximaPlaça() {
        boolean plaçaTrobada = false;

        if (placesLliures > 0) {
            int i = proximaPlaça;
            while(i < places.length && !plaçaTrobada) {
                if (places[i].getMatricula() == null) {
                    proximaPlaça = i;
                    plaçaTrobada = true;
                }
                i++;
            }
        } else {
            proximaPlaça = -1; //indica que no quedan plazas libres
            System.out.println("Aparcament complet.");
        }

    }

}
