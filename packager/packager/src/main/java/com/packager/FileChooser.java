package com.packager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileChooser {
    //region ouvrir fichier extension
    /*
    public void actionPerformed( ActionEvent e ){

        AppFilter filtre   = new AppFilter( new String[] {"jpg", "png", "gif"}, "fichiers au format image" );

        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter( filtre );

        int retour = chooser.showDialog( fenetre, "Charger l'image" );

// si l'utilisateur a cliqué sur le bouton "Charger l'image"
        if ( retour == 	JFileChooser.APPROVE_OPTION ){

            String path = chooser.getSelectedFile().getPath();
            String name = chooser.getSelectedFile().getName();

// après je te laisse compléter car tu as maintenant les outils pour manipuler ton fichier image selectionner

        }
    }*/
    //endregion

    public void lectureImage(String nomFichier) {
        try {
            BufferedImage image = ImageIO.read(new File(nomFichier));

            int largeurImage = image.getWidth();
            int hauteurImage = image.getHeight();

            Color couleur;
            for(int colonne = 0; colonne < largeurImage; colonne++){
                for(int ligne = 0; ligne < hauteurImage; ligne++){
                    couleur = new Color(image.getRGB(colonne, ligne), false);
                    // Traitement ici
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
