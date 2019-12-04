package com.packager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.imageio.ImageIO.read;

/**
 * Convertir une image en nuance de gris
 * @author Axel - ® fobec.com 2010
 */
public class BnWFilter {

    public static void bnWfilter(String args[]) {
        try {
            System.out.println("Début de conversion....");
            //Ouverture du fichier
            /**
             * Image d'entrée en couleur
             */
            String inFilename = "file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgin/imgteste.png";
            File inputFile = new File("file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgin");
            BufferedImage imagesrc;
            imagesrc = read(new File("file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgin"));
            //Convertion en grisé
            BufferedImage imagedst = new BufferedImage(imagesrc.getWidth(),

                    imagesrc.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            Graphics g = imagedst.getGraphics();
            g.drawImage(imagesrc, 0, 0, null);
            g.dispose();
            //Enregistrer l'image au format PNG
            /**
             * Image de sortie en nuance de gris
             */
            String outFilename = "file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgout/";
            File outFile = new File("file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgout");
            ImageIO.write(imagedst, "png", new File("file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgin"));
            System.out.println("Fin de conversion....");
        } catch (IOException ex) {
            Logger.getLogger(BnWFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

