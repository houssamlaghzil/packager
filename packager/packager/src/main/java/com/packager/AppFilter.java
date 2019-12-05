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


public abstract class AppFilter {

    public static void main(String[] args) {
        System.out.println("application has started");

        usingFilters( whichFilters( createCLI(args) ));


    }


    public static String createCLI(String[] args){      // surement pas encore fini, mais il y a déja de l'avancement
        String filterArg = "";

        Options options = new Options();
        options.addOption("h", "help", false, "")
                .addOption("i", "input", false, "-dir <directory>")
                .addOption("o", "output", false, "-dir <directory>")
                .addOption("f", "filters", true, "filters options")
        ;

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("imageFilter", options);

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("h")){
                System.out.println("help option was used");
            }
            if(cmd.hasOption("i")){
                System.out.println("input option was used");
            }
            if(cmd.hasOption("o")){
                System.out.println("output option was used");
            }
            if(cmd.hasOption("f")){
                System.out.println("filters selected was used: " + cmd.getOptionValue("f"));
                filterArg = cmd.getOptionValue(("f"));
            }
        }catch (Exception e ){
            System.out.println(e);
        }


        //region try 1 CLI
        /*
        Options options = new Options();
        options.addOption("h","help",  false, "display command list");
        //options.addOption(Option.builder().withLongOpt("block-size"));
        Option logfile= Option.builder().longOpt("input").argName("i").hasArg().desc("input file name").build();
        options.addOption(logfile);

        //options.addOption("i","input",  false, "display command list");
        options.addOption("o","output",  false, "display command list");

        CommandLineParser parser = new DefaultParser();
        try{
            CommandLine cmd = parser.parse( options, args);
            if (cmd.hasOption("help")) {
                System.out.println(cmd.getOptionValue("help"));
            }
        }catch (Exception e) {
            System.out.println(e);
        }


        */
//endregion


        return filterArg;
    }


    public static Map<IFilter, Integer> whichFilters(String filterArg){
        Map<IFilter, Integer> filtersOptions = new HashMap<>(); // List contenant l'objet IFilter, et un entier: size utilisé pour BlurFilter
        // et DilateFilter (on a du modifier IFilter en ajoutant l'argument int en plus de Mat
        int size = 0;

        String[] splitFilters = filterArg.split("\\|");  //liste contenant des string formé a partir de la separation d'un String (celui aprés -f en CLI)
        // selon le caractère '\'

        for (String s : splitFilters){

            String[] splitValue = s.split(":");         //on decoupe les quelques String restant (tel que Blur:3 et Dilate:10)
            System.out.println(s + " puis " + splitValue[0]);
            switch (splitValue[0]){
                case "blur":
                    size = Integer.parseInt(splitValue[1]);         //on passe d'un String a un Integer
                    filtersOptions.put(new BlurFilter(),size);
                    break;
                case  "grayscale":
                    filtersOptions.put(new BnWFilter(),size);
                    break;
                case  "dilate":
                    size = Integer.parseInt(splitValue[1]);
                    filtersOptions.put(new DilateFilter(),size);
                    break;
            }
        }

        return filtersOptions;
    }


    public static void usingFilters(Map<IFilter, Integer> filtersOptions){
        String dir = "/Users/Gwenael/Desktop/packager/packager/packager/src/main/java/imageIn";
        String dirOut = "/Users/Gwenael/Desktop/packager/packager/packager/src/main/java/imageOut";
        File rep = new File(dir);
        String liste[] = rep.list();

        if (liste != null){

            for(int i =0; i<liste.length;i++) {
                String cheminIn = dir + "/" + liste[i];
                String cheminOut = dirOut + "/" + liste[i];

                try {
                    Mat img = imread(cheminIn);
                    for (Map.Entry<IFilter, Integer> entry : filtersOptions.entrySet()) {
                        img = entry.getKey().filter(img, entry.getValue());
                    }
                    imwrite(cheminOut, img);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }


    }
}

