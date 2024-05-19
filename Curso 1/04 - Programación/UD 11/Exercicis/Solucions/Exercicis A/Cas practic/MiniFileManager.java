/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uf11_cas_practic;

import java.io.File;
import java.net.URI;
import java.util.Iterator;

/**
 *
 * @author s.rueorquin
 */
public class MiniFileManager {
    
    
    private static File dirActual = new File("");
    
    //També es pot fer servir
    //private static File dirActual = new File(System.getProperty("user.dir"));
    
    
    public static String getPWD(){
        return dirActual.getAbsolutePath();
    }
    
    public static boolean changeDir(String dir){
        File dirNou = new File(dir);
        boolean canviat = false;
        
        if(dirNou.isDirectory() && dirNou.exists()){
            dirActual = dirNou;
            canviat = true;
        }else
            System.out.println("No s'ha trobat la ruta indicada");
                    
        return canviat;
    }
    
    public static void makeDir(String dir){
        
        File dirNou = new File(dir);
        
        if (dirNou.mkdir()) {
            System.out.println("Directori creat: " + dirNou.getAbsolutePath());
        } else {
            System.out.println("Error al crear el directori: " + dirNou);
        }
    
    }
    
    public static void removeDir(File dir){
        
        File[] contingut = dir.listFiles();
        boolean eliminada = true;

        if(taSubDir(contingut))
            eliminada = false;
        else{
            for(File f : contingut){
                if(f.delete())
                   System.out.println(f.getName() + " esborrat");
                else{
                   System.out.println("Error al esborrar l'arxiu: " + f.getAbsolutePath());
                   eliminada = false;
                }
            }
        }
        
        if(eliminada && dir.delete()){
            System.out.println("La carpeta " + dir.getAbsolutePath() + " ha sigut eliminada");
        }else
            System.out.println("La carpeta " + dir.getAbsolutePath() + " no s'ha esborrat perque no s'ha pogut eliminar el contigut");

    }
    
    public static boolean taSubDir(File[] subdirs){
        boolean teSubdir = false;
        
        int i = 0;
        
        while(!teSubdir && i < subdirs.length){
            if(subdirs[i].isDirectory())
                teSubdir = true;
            i++;
        }
        
        return teSubdir;
    }
    
    public static boolean moveDir(File origen, File desti){
        boolean canviat = false;
        
        if(origen.exists()){
            origen.renameTo(desti);
            canviat = true;
            System.out.println("Canviat " + origen + " a " + desti);
        }else
            System.out.println("No s'ha pogut moure o canviar el nom de l'arxiu" + origen + " a " + desti);

        return canviat;
    }
    
    public static void listDir(boolean info){
        File[] arxius = dirActual.listFiles();
        
        for(File f : arxius){
            System.out.print(f.getName());
            
            if(info){
                System.out.println(" " + f.length() + " " + f.lastModified());
            }else
                System.out.println("");
        
        }
    }
    
    public static void help(){
        System.out.println("pwd - Mostra la ruta del directori actual");
        System.out.printf("\tExemple: > pdw\n\n");
        
        System.out.println("cd - Canvia el directori actual a la ruta especificada");
        System.out.printf("\tExemple: > cd /Documents/Fotos\n\n");
        
        System.out.println("ll - Mostra els noms del contingut del directori actual");
        System.out.printf("\tExemple: > ll\n\n");
        
        System.out.println("ls - Mostra els noms, el tamany i l'ultima modificació del contingut del directori actual");
        System.out.printf("\tExemple: > ls\n\n");
        
        System.out.println("mkdir - Crea un nou directori a la ruta especificada");
        System.out.printf("\tExemple: > mkdir ./Programacion\n\n");
        
        System.out.println("rm - Elimina el directori de la ruta especificada");
        System.out.printf("\tExemple: > rm Fotos\n\n");
        
        System.out.println("mv - Mou el primer element a la ruta indicada, si no hi ha ruta canvia el nom");
        System.out.printf("\tExemple: > mv ./Fotos users/jo/Fotos \n");
        System.out.printf("\tExemple: > mv ./Fotos/foto1.jpg users/jo/Fotos.foto2.jpg (canvia el nom)\n\n");
        
        System.out.println("exit - Finalitza el terminal\n");
    
    }
    
}
