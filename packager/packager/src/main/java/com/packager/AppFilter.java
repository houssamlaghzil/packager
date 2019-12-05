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

        usingFilters( whichFilters( createCLI(args) ));


    }

    /**
     * this method generate the CLI, and get a String with all the filter that have to be used and their power
     * @param args      the program arguments , you can set them when editing configuration
     * @return          String : containing all the information about filters to be applied from the CLI
     */
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

    /**
     * this method analyse the String in parameters (filterArg) and determine which filters we will use on pictures. we save the filter type
     * chosen and the value associated in an HashMap
     * @param filterArg     String : containing all the information about filters to be applied from the CLI
     * @return              Map : containing an IFilter as key, and Integer as value for each filter selected from the CLI
     */
    public static Map<IFilter, Integer> whichFilters(String filterArg){
        Map<IFilter, Integer> filtersOptions = new HashMap<>(); // List contenant l'objet IFilter, et un entier: size utilisé pour BlurFilter
        // et DilateFilter (on a du modifier IFilter en ajoutant l'argument int en plus de Mat
        int size = 0;           //utile pour le cas ou il y a un grayscale demander

        String[] splitFilterArg = filterArg.split("\\|");  //liste contenant des string formé a partir de la separation d'un String (celui aprés -f en CLI)
        // selon le caractère '|'

        for (String s : splitFilterArg){

            String[] splitValue = s.split(":");         //on decoupe les String obtenu (tel que Blur:3 et Dilate:10)
            System.out.println(s + " puis " + splitValue[0]);
            switch (splitValue[0]){
                case "blur":
                    size = Integer.parseInt(splitValue[1]);         //on passe d'un String a un Integer,
                                                                    // peut etre un try si peut devenir un entier
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

