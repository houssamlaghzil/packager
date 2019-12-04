package com.packager;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public abstract class AppFilter {
    public static void main(String[] args) {

        List<IFilter> filterArray = new ArrayList<>();
        filterArray.add(new BlurFilter());
        filterArray.add(new BnWFilter());
        filterArray.add(new DilateFilter());



        String dir = "/Users/franceebbasta/Desktop/packager/packager/packager/src/main/java/imageIn";
        String dirOut = "/Users/franceebbasta/Desktop/packager/packager/packager/src/main/java/imageOut";

        File rep = new File(dir);
        String liste[] = rep.list();
        if (liste != null){
            for(int i =0; i<liste.length;i++){
                IFilter blurFilter = new BlurFilter();
                IFilter dilateFilter = new DilateFilter();
                IFilter bnWFilter = new BnWFilter();
                String cheminIn = dir + "/" +liste[i];
                String cheminOut = dirOut + "/" + liste[i];

                try {
                    blurFilter.filter(cheminIn, cheminOut);
                    dilateFilter.filter(cheminOut ,cheminOut);
                    bnWFilter.filter(cheminOut,cheminOut);
                }catch (Exception e)
                {
                    System.out.println(e);
                }

            }

        }
        else{
            System.err.println("nom invalide");
        }


    }
}

