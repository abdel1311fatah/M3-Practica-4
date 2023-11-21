package org.example;

import java.io.File;
import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public String ruta() {

        boolean valid = false;
        String ruta = "";
        String opcio = obtindreString("Escriu: 'si' si vols elegir una ruta per a guardar les dades o escriu 'no' per a utilitzar la predeterminada: ");
        while (!valid) {
            if (opcio.equalsIgnoreCase("si")) {
                ruta += obtindreString("Introdueix la ruta a la que vols crear els arxius: ");
                File file = new File(ruta);
                if (file.exists()) {
                    ruta.replace("\\", "/");
                    ruta += "/";
                    return ruta;
                } else {
                    System.out.println("La ruta que has introduit no existeix o no es una carpeta ");
                }
            } else if (opcio.equalsIgnoreCase("no")) {
                ruta = "src/Files/";
                return ruta;
            } else {
                System.out.println("Has d' introduir si o no, torna a provar: ");
                opcio = obtindreString("Escriu: 'si' si vols elegir una ruta per a guardar les dades o escriu 'no' per a utilitzar la predeterminada: ");
            }
        }
        return ruta;
    }

    public String[] texte(){

        boolean acabar = false;
        String texteBrut = "";
        String[] texteSeparat;

        while (!acabar){
            texteBrut += obtindreString("Escriu coses, pots ficar 'exit' per a sortir \n");
            if (texteBrut.equalsIgnoreCase("exit")){
                acabar = true;
            }
        }

        texteSeparat = texteBrut.split("\\s"); // regex de l' espai

        return texteSeparat;
    }

    public String tipusVariable(String[] texte){

        String resultat = "";
        boolean esNumero = false;
        for (int i = 0; i < texte.length; i++) { // aqui recorrem les posicions del texte brut separat per espais
            for (int j = 0; j < texte[i].length(); j++) { // aqui recorrem cada caracter de cada item del texte separat

            }
        }
        return resultat;
    }

    public boolean esNumero(String[] texte){

        boolean esNumero = false;
        for (int i = 0; i < texte.length; i++) { // aqui recorrem les posicions del texte brut separat per espais
            for (int j = 0; j < texte[i].length(); j++) { // aqui recorrem cada caracter de cada item del texte separat
                if(Character.isDigit(texte[i].charAt(j))){
                    esNumero = true;
                }else{
                    esNumero = false; // la tornem a ficar a false per a que si fiquem un numero i despues una lletra no conti com que es un numero
                }
            }
        }

        return esNumero;
    }

    public boolean esCaracter(String[] texte){

        boolean esCaracter = false;
        for (int i = 0; i < texte.length; i++) { // aqui recorrem les posicions del texte brut separat per espais
            for (int j = 0; j < texte[i].length(); j++) { // aqui recorrem cada caracter de cada item del texte separat
               if(texte[i].length() == 1){
                   esCaracter = true;
               }else{
                   esCaracter = false;
               }
            }
        }

        return esCaracter;
    }

    public String obtindreString(String text) {
        Scanner sc = new Scanner(System.in);

        System.out.print(text);
        String text_usuari = sc.nextLine();

        return text_usuari;
    }

}
