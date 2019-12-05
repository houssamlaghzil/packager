package com.packager;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;


public abstract class AppFilter {
    public static void main(String[] args) {

        CommandLineParser parser = new DefaultParser();

        // create the Options
        Options options = new Options();
        
        options.addOption( "h", "help", false, "" );
        options.addOption( "i", "input-dir", true, "" );
        options.addOption( "o", "output-dir", true, "" );


        List<IFilter> filterArray = new ArrayList<>(); // liste des filtres a applliqué

        System.out.println(args.length+" args" );
        String filterArg = "ce qui est en ligne de commande";
        String[] split = filterArg.split("\\|");

        for (String s : split){
            // s = blur:3
            // s = grayscale
            String[] split2 = s.split("\\:");
            // blur, 3 ==> size=2
            // grayscale ==> size=1

            String param = "";
            if(split2.length == 2){
                param = split2[1];
            }

            //integer.parsint(a) int
            switch (split2[0]){
                case "blur":
                    int i = Integer.parseInt(param);
                    filterArray.add(new BlurFilter());
                    break;
                case  "bnw":

                    filterArray.add(new BnWFilter());
                    break;
                case  "dilate":
                    int j = Integer.parseInt(param);
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

