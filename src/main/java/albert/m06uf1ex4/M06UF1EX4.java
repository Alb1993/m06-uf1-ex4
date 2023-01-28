/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package albert.m06uf1ex4;

import java.io.File;
import java.util.Scanner;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

/**
 *
 * @author Albert
 */
public class M06UF1EX4 {

    public static void main(String[] args) {
        
        /***
         * Introducimos la ruta y el Texto a buscar.
         */
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce ruta archivo:");
        String xmlFile = in.nextLine();
        
        System.out.println("Intro Caracter a buscar:");
        String searchString = in.nextLine().toLowerCase();

        try {
            /***
             *  Crea un objeto Builder para procesar el fichero XML.
             */
            Builder builder = new Builder();
            File file = new File(xmlFile);
            Document doc = builder.build(file);
            Element root = doc.getRootElement();

            /***
             * Obtiene todos los CDs del fichero.
             */
            Elements cds = root.getChildElements("CD");
            
            /***
             * Recorre todos los elementos CD que hemos recogido antes i busca coincidencias en artista o titulo.
             */
            for (int i = 0; i < cds.size(); i++) {
                Element cd = cds.get(i);
                String title = cd.getFirstChildElement("TITLE").getValue().toLowerCase();
                String artist = cd.getFirstChildElement("ARTIST").getValue().toLowerCase();

                /***
                 * Muestra los datos en la consola.
                 */
                if (title.contains(searchString) || artist.contains(searchString)) {
                    System.out.println("Títol: " + cd.getFirstChildElement("TITLE").getValue());
                    System.out.println("Artista: " + cd.getFirstChildElement("ARTIST").getValue());
                    System.out.println("País: " + cd.getFirstChildElement("COUNTRY").getValue());
                    System.out.println("Discogràfica: " + cd.getFirstChildElement("COMPANY").getValue());
                    System.out.println("Preu: " + cd.getFirstChildElement("PRICE").getValue());
                    System.out.println("Any: " + cd.getFirstChildElement("YEAR").getValue());
                    System.out.println("-------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

