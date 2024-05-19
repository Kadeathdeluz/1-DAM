package exercicist11.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class ExercicisT11PRG_A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //exercici1A();
        //exercici2A();
        //exercici3A();

    }

    private static void exercici1A() {
        Scanner input = new Scanner(System.in);
        String rutaIntroduida = "";

        do {
            try {
                System.out.println("Per favor introdueix una ruta (buit per a eixir) : ");
                rutaIntroduida = input.nextLine();

                if (!rutaIntroduida.isBlank()) {
                    File file = new File(rutaIntroduida);
                    mostraInfoRuta(file);
                }
            } catch (FileNotFoundException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }

        } while (!rutaIntroduida.isEmpty());
    }

    private static void mostraInfoRuta(File ruta) throws FileNotFoundException {
        if (!ruta.exists()) {
            throw new FileNotFoundException("La ruta no existeix.");
        }

        //Si és arxiu
        if (ruta.isFile()) {
            System.out.println("Nom de l'arxiu: [A]" + ruta.getName());

            //Si és carpeta
        } else if (ruta.isDirectory()) {
            File[] contingut = ruta.listFiles();
            System.out.println("La carpeta [*]" + ruta.getName() + " conté: ");

            //Recorre l'array per mostrar les carpetes
            for (File file : contingut) {
                if (file.isDirectory()) {
                    System.out.println("[*] " + file.getName());
                }
            }
            //Recorre l'array per mostrar els arxius
            for (File file : contingut) {
                if (file.isFile()) {
                    System.out.println("[A] " + file.getName());
                }
            }
        }

    }

    private static void exercici2A() {
        Scanner input = new Scanner(System.in);
        String rutaIntroduida = "";

        do {
            try {
                System.out.println("Per favor introdueix una ruta (buit per a eixir) : ");
                rutaIntroduida = input.nextLine();

                if (!rutaIntroduida.isBlank()) {
                    File file = new File(rutaIntroduida);
                    mostraInfoRutaV2(file, true);
                }
            } catch (FileNotFoundException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }

        } while (!rutaIntroduida.isEmpty());
    }

    private static void mostraInfoRutaV2(File ruta, boolean info) throws FileNotFoundException {
        if (!ruta.exists()) {
            throw new FileNotFoundException("La ruta no existeix.");
        }
        //Si és arxiu
        if (ruta.isFile()) {
            System.out.println("Nom de l'arxiu: [A]" + ruta.getName());

            //Si és carpeta
        } else if (ruta.isDirectory()) {
            File[] contingut = ruta.listFiles();
            Arrays.sort(contingut);

            System.out.println("La carpeta [*]" + ruta.getName() + " conté: ");

            //Recorre l'array per mostrar les carpetes
            for (File file : contingut) {
                if (file.isDirectory()) {
                    System.out.print("[*] " + file.getName());
                    if (info) {
                        System.out.print(" - info: tamany: " + file.length() + "Bytes, últ. mod.: " + new Date(file.lastModified()));
                    }
                    System.out.println("");
                }
            }
            //Recorre l'array per mostrar els arxius
            for (File file : contingut) {
                if (file.isFile()) {
                    System.out.print("[A] " + file.getName());
                    if (info) {
                        System.out.print(" - info: tamany: " + file.length() + "Bytes, últ. mod.: " + new Date(file.lastModified()));
                    }
                    System.out.println("");
                }
            }
        }

    }

    private static void exercici3A() {
        String documents = "Documentos";
        String fotografies = documents + "/Fotografias";
        String llibres = documents + "/Libros";

        //De Fotografias a FOTOS
        File fotoOrigen = new File(fotografies);
        File fotoDestino = new File(fotoOrigen.getParent() + "/FOTOS");
        fotoOrigen.renameTo(fotoDestino);

        //De Libros a LECTURAS
        File libOrigen = new File(llibres);
        File libDestino = new File(libOrigen.getParent() + "/LECTURAS");
        libOrigen.renameTo(libDestino);

        //De Documentos a DOCS
        File docsOrigen = new File(documents);
        File docsDestino = new File("DOCS");
        docsOrigen.renameTo(docsDestino);

        //Listas de ficheros en fotos y libros
        File[] fotos = fotoDestino.listFiles();
        File[] libs = libDestino.listFiles();

        //@Todo: canviar el nom de tots els arxius dins de FOTOS i LECTURA.
    }
}
