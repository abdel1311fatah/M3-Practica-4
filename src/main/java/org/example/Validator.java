package org.example;

public class Validator {

    public String tipusVariable(String[] texte){

        String resultat = "";
        boolean esNumero = false;
        for (int i = 0; i < texte.length; i++) { // aqui recorrem les posicions del texte brut separat per espais
            for (int j = 0; j < texte[i].length(); j++) { // aqui recorrem cada caracter de cada item del texte separat

            }
        }
        return resultat;
    }

    public boolean esInt(String[] texte){

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

    public boolean esDouble(String[] texte){

        boolean esNumero = false;
        int contadorPunts = 0; // per validar que no fiquis 7..8
        for (int i = 0; i < texte.length; i++) { // aqui recorrem les posicions del texte brut separat per espais
            for (int j = 0; j < texte[i].length(); j++) { // aqui recorrem cada caracter de cada item del texte separat
                if(Character.isDigit(texte[i].charAt(j))) {
                    esNumero = true;
                } else if (texte[i].charAt(j) == '.'){ // la i represente la posicio del array de items que has escrit i la j la posicio del caracter de cada item
                    contadorPunts++;
                    if(contadorPunts == 1 && (Character.isDigit(texte[i].charAt(j-1)) && Character.isDigit(texte[i].charAt(j+1)))){ // validar que estigui entre mig de 2 numeros
                        esNumero = true; // es double ja que nomes te un punt
                    }else{
                        esNumero = false; // o no te punts o en te mes de un
                    }
                }else{
                    esNumero = false; // la tornem a ficar a false per a que si fiquem un numero i despues una lletra no conti com que es un numero
                }
            }
        }
        return esNumero;
    }

}
