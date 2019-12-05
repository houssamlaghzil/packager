package com.packager;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.presets.opencv_core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

/**
 * this is the main class of our app
 */
public abstract class AppFilter {

    /**
     * this is the main method, hope you're surprised
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("application has started");
    public static void main(String[] listeArguments) {

        System.out.println(listeArguments[0]);



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

       
    }


    /**
     * this method apply the filters containing in the Map in parameters to all Files from a specified directory.
     * @param filtersOptions    Map : containing an IFilter as key, and Integer as value for each filters selected from the CLI
     */
    public static void usingFilters(Map<IFilter, Integer> filtersOptions){
        String dir = "/Users/Gwenael/Desktop/packager/packager/packager/src/main/java/imageIn";
        String dirOut = "/Users/Gwenael/Desktop/packager/packager/packager/src/main/java/imageOut";
        File rep = new File(dir);
        String list[] = rep.list();

        if (list != null){

            for(int i =0; i<list.length;i++) {
                String pathIn = dir + "/" + list[i];
                String pathOut = dirOut + "/" + list[i];

                try {
                    Mat img = imread(pathIn);
                    for (Map.Entry<IFilter, Integer> entry : filtersOptions.entrySet()) {
                        img = entry.getKey().filter(img, entry.getValue());
                    }
                    imwrite(pathOut, img);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }


    }
}

