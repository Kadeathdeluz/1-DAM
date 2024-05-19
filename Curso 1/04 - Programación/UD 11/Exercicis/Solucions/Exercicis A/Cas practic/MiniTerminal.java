/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uf11_cas_practic;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s.rueorquin
 */
public class MiniTerminal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File file1, file2;
        boolean exit = false;
        
        Scanner scanner = new Scanner(System.in);
        
        String directoriActual = MiniFileManager.getPWD();
        
        do{
            
            System.out.print("user > ");
            
            //Mostra l'usuari del sistema
            //System.out.print(System.getProperty("user.name") + " > ");
            
            String[] command = scanner.nextLine().trim().split(" ");

            switch(command[0].toLowerCase()){

                case "pwd":
                    System.out.println(MiniFileManager.getPWD());
                    break;
                case "cd":
                    if(command.length > 1 && command[1] != null && !command[1].isBlank())
                        MiniFileManager.changeDir(command[1]);
                    break;
                case "ls":
                        MiniFileManager.listDir(false);
                    break;
                case "ll":
                        MiniFileManager.listDir(true);
                    break;
                case "mkdir":
                    if(command.length > 1 && command[1] != null && !command[1].isBlank())
                        MiniFileManager.makeDir(command[1].trim());
                    break;
                case "mv":
                    if(command.length > 2 && command[1] != null && !command[1].isBlank()){
                        file1 = new File(command[1].trim());
                        file2 = new File(command[2].trim());
                        MiniFileManager.moveDir(file1, file2);
                    }
                    break;
                case "rm":
                    if(command.length > 1 && command[1] != null && !command[1].isBlank()){
                        file1 = new File(command[1].trim());
                        MiniFileManager.removeDir(file1);
                    }
                    break;
                case "help":
                        MiniFileManager.help();
                    break;
                case "exit":
                        System.out.println("Finalitza el terminal");
                        exit = true;
                    break;
                default:
                    System.out.println("No es reconeix el command " + command + " Escriu 'help' per veure les opcions");
            }
        }while(!exit);

    }
    
}
