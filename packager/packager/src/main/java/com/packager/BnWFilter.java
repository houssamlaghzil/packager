package com.packager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import static javax.imageio.ImageIO.read;

/**
 * Convertir une image en nuance de gris
 * @author Axel - ® fobec.com 2010
 */
public class BnWFilter {

<<<<<<< Updated upstream
    public static void bnWfilter(String args[]) {
        try {
            System.out.println("Début de conversion....");
            //Ouverture du fichier
            /**
             * Image d'entrée en couleur
             */
            String inFilename = "file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgin/8326519c9fbbbb4.png";
            File inputFile = new File(inFilename);
            BufferedImage imagesrc;
            imagesrc = read(inputFile);
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
            File outFile = new File(outFilename);
            ImageIO.write(imagedst, "PNG", outFile);
            System.out.println("Fin de conversion....");
        } catch (IOException ex) {
            Logger.getLogger(BnWFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
=======

}
>>>>>>> Stashed changes
