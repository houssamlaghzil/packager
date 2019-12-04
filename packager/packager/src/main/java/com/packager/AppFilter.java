package com.packager;

import java.io.File;

public abstract class AppFilter {
    public static void main(String[] args) throws FilterException {


        String dir = "/Users/franceebbasta/Desktop/packager/packager/packager/src/main/java/imageIn";
        String dirOut = "/Users/franceebbasta/Desktop/packager/packager/packager/src/main/java/imageOut";

        File rep = new File(dir);
        String liste[] = rep.list();
        if (liste != null){
            for(int i =0; i<liste.length;i++){
                System.out.println(dir + liste[i]);
                IFilter blurFilter = new BlurFilter();
                IFilter dilateFilter = new DilateFilter();
                IFilter bnWFilter = new BnWFilter();
                String cheminIn = dir + "/" +liste[i];
                String cheminOut = dirOut + "/" + liste[i];
                blurFilter.filter(cheminIn,cheminOut);
                dilateFilter.filter(cheminOut ,cheminOut);
                bnWFilter.filter(cheminOut,cheminOut);
            }

        }
        else{
            System.err.println("nom invalide");
        }

    }

}
