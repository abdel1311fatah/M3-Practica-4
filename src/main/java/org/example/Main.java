package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        String rutaCarpeta = menu.ruta();

        //Apartat 3 d' elegir la carpeta on se volen guardar els arxius
        try {
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                carpeta.createNewFile();
                System.out.println("El arxiu no existia, per lo que s ha creat");
            }

            if (carpeta.isDirectory()) {

                //Apartat 2 de agafar el nom que voldrem del fixer
                String nomArxiu = menu.obtindreString("Introdueix el nom de l' arxiu de texte: ");

                //Apartat 1 de mirar i crear la ruta del arxiu
                try {
                    File arxiu = new File(rutaCarpeta, nomArxiu); // aqui esta el constructor de l' arxiu amb la ruta i el nom

                    if (!arxiu.exists()) {
                        arxiu.createNewFile();
                        System.out.println("El arxiu no existia per lo que s ha creat");
                    }

                    //Escriure el texte al arxiu

                    String texteArxiuEscriure = menu.obtindreString("Introdueix el texte que vols que tingui l' arxiu: ");

                    FileWriter fw = new FileWriter(arxiu);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(texteArxiuEscriure);

                    bw.close();
                    fw.close(); // tanquem per a que escrigui

                    //Apartat 4

                    FileReader fr = new FileReader(arxiu);
                    BufferedReader br = new BufferedReader(fr);

                    //Apartat 5 dir el tipus de dada filtrada per posicio d array de strings

                    String texteAseparar = "";
                    ArrayList<String> texteArxiu = new ArrayList<>(); // recollim el texte de l arxiu i el fiquem en un arraylist
                    while ((texteAseparar = br.readLine()) != null) { // fins que no estgigui buit rellenem el arraylist
                        texteArxiu.addAll(Arrays.asList(texteAseparar.split("\\s+"))); // regex de l' espai
                    }

                    // les regex estan tretes d' internet
                    // int:
                    // https://es.stackoverflow.com/questions/55403/ayuda-con-expresi%C3%B3n-regular per als int amb aixo al principi -? fem que tambe agafin negatius,
                    // i amb el [0-9] mirem que siguin numeros, el $ es per tancar la cadena

                    //double:
                    // https://stackoverflow.com/questions/14563106/java-regex-on-doubles per als double
                    // ("^[\\+\\-]{0,1}[0-9]+[\\.\\,]{1}[0-9]+$")) -> el ^ es el inici de la cadena, aixo [\\+\\-] es per a que agafi o signe mes o signe menys,
                    // aixo {0,1} signifique que el mes o el menys nomes poden apareixer una vegada, despres agafe un numero del 0 al nou amb aixo [0-9] i despres agafe un punt,
                    // mire que nomes agafi un punt amb aixo {1}, torne a buscar un numero del 0 al 9 i el $ acabe la cadena

                    for (int i = 0; i < texteArxiu.size(); i++) { // recorrem cada paraula del array
                        if(texteArxiu.get(i).matches("^-?[0-9]*$")) {
                            System.out.println(texteArxiu.get(i) + " es un int\n");
                        } else if (texteArxiu.get(i).matches("^[\\+\\-]{0,1}[0-9]+[\\.\\,]{1}[0-9]+$")) {
                            System.out.println(texteArxiu.get(i) + " es un double\n");
                        } else if (texteArxiu.get(i).length() == 1) { // si no es un numero es un altra cosa, i si nomes te largada 1 es un char
                            System.out.println(texteArxiu.get(i) + " es un caracter\n");
                        } else {
                            System.out.println(texteArxiu.get(i) + " es un string\n");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (carpeta.isFile()) {
                System.out.println("La ruta " + rutaCarpeta + " es un fixer, has d' introduir la ruta d' una carpeta");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}