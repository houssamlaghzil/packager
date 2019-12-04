package com.packager;


import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;


public abstract class AppFilter {
    public static void main(String[] args) {


        List<IFilter> filterArray = new ArrayList<>(); // liste des filtres a applliqué


        String filterArg = "ce qui est en ligne de commande";
        String[] split = filterArg.split("\\|");

        for (String s : split){
            switch (s){
                case "blur":
                    filterArray.add(new BlurFilter());
                    break;
                case  "grayscale":
                    filterArray.add(new BnWFilter());
                    break;
                case  "dilate":
                    filterArray.add(new DilateFilter());
                    break;
            }
        }



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
                    Mat img = imread(cheminIn);
                    for (IFilter f : filterArray) {
                        img = f.filter(img);
                    }
                    imwrite(cheminOut, img);

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

