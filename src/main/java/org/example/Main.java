package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        Validator validator = new Validator();
        String ruta = menu.ruta();
        try {
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("El arxiu no existie, per lo que s ha creat");
            }

            if (file.isDirectory()) {
                System.out.println("La ruta " + ruta + " es un directori");
            } else {
                System.out.println("Has introduit la ruta d' un arxiu, has d' introduir la ruta d' una carpeta");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}