package com.packager;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

/**
 * this is the main class of our app
 */
public abstract class AppFilter {

    /**
     * this is the main method, hope you're surprised
     * @param args      the program arguments, you can defined them by editing Configuration
     */
    public static void main(String[] args) {
        System.out.println("application has started");

        List<String> listCommandArgs = createCLI(args);
        Map<IFilter, Integer> filtersOptions = whichFilters( listCommandArgs );
        usingFilters(filtersOptions , listCommandArgs);

    }


    /**
     * this method generate the CLI and get all the information we need from the program arguments
     * @param args  the program arguments, you can defined them by editing Configuration
     * @return      List : a String list used to have the in directory , out directory and all the filters arguments
     */
    public static List<String> createCLI(String[] args){      // surement pas encore fini, mais il y a déja de l'avancement
        String filterArg = "";
        String dirIn = "/Users/Gwenael/Desktop/packager/packager/packager/src/main/java/imageIn";
        String dirOut = "/Users/Gwenael/Desktop/packager/packager/packager/src/main/java/imageOut";

        HelpFormatter formatter = new HelpFormatter();
        List<String> listCommandArgs = new ArrayList<>();


        Options options = new Options();
        options.addOption("h", "help", false, "")
                .addOption("i", "input", true, "-dir <directory>")
                .addOption("o", "output", true, "-dir <directory>")
                .addOption("f", "filters", true, "filters options")
        ;


        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("h")){
                System.out.println("help option was used");
                formatter.printHelp("imageFilter", options);
            }
            if(cmd.hasOption("i")){     //il faudrait pouvoir recuperer un chemin de moins de 100 caractère dans l'idéale
                System.out.println("input option was used");
                dirIn = cmd.getOptionValue("i");
            }
            if(cmd.hasOption("o")){
                System.out.println("output option was used");
                dirOut = cmd.getOptionValue("o");
            }
            if(cmd.hasOption("f")){
                System.out.println("filters selected was => " + cmd.getOptionValue("f"));
                filterArg = cmd.getOptionValue(("f"));
            }
        }catch (Exception e ){
            System.out.println(e);
        }

        listCommandArgs.add(dirIn);
        listCommandArgs.add(dirOut);
        listCommandArgs.add( filterArg);

        return listCommandArgs;
    }



    /**
     * this method analyse the filters arguments from a List given in parameter, and create an HashMap with all the selected filters and their power
     * @param listCommandArgs   List : a String list used here to have all the filters arguments
     * @return                  Map : containing all filter's type and their effect's power
     */
    public static Map<IFilter, Integer> whichFilters(List<String> listCommandArgs){
        Map<IFilter, Integer> filtersOptions = new HashMap<>(); // List contenant l'objet IFilter, et un entier: size utilisé pour BlurFilter
        // et DilateFilter (on a du modifier IFilter en ajoutant l'argument int en plus de Mat
        int size = 0;
        FilterLogger logger = new FilterLoggerFile();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        String[] splitFilters = listCommandArgs.get(2).split("\\|");  //liste contenant des string formé a partir de la separation d'un String (celui aprés -f en CLI)
        // selon le caractère '\'

        for (String s : splitFilters){

            String[] splitValue = s.split(":");         //on decoupe les quelques String restant (tel que Blur:3 et Dilate:10)
            switch (splitValue[0]){
                case "blur":
                    size = Integer.parseInt(splitValue[1]);         //on passe d'un String a un Integer
                    filtersOptions.put(new BlurFilter(),size);
                    logger.log(format.format(date) + " you want to apply " + splitValue[0] +". value: " + splitValue[1]);
                    break;
                case  "grayscale":
                    filtersOptions.put(new BnWFilter(),size);
                    logger.log(format.format(date) + " you want to apply " + splitValue[0]);
                    break;
                case  "dilate":
                    size = Integer.parseInt(splitValue[1]);
                    filtersOptions.put(new DilateFilter(),size);
                    logger.log( format.format(date) + " you want to apply " + splitValue[0] +". value: " + splitValue[1]);
                    break;
            }
        }

        return filtersOptions;
    }



    /**
     * this method apply the filters containing in the Map in parameters to all Files from a specified directory and save them in an other.
     * directories are in the listCommandArgs (0 for in directory, 1 for out directory)
     * @param filtersOptions    Map : containing an IFilter as key, and Integer as value for each filters selected from the CLI
     * @param listCommandArgs   List : a String list used here to have the in directory and the out directory
     */
    public static void usingFilters(Map<IFilter, Integer> filtersOptions, List<String> listCommandArgs){
        String dirIn = listCommandArgs.get(0);
        String dirInTab[] = dirIn.split("/");
        String dirInRac = dirInTab[dirInTab.length-1];

        String dirOut = listCommandArgs.get(1);
        String dirOutTab[] = dirOut.split("/");
        String dirOutRac = dirOutTab[dirOutTab.length-1];

        File rep = new File(dirIn);
        String liste[] = rep.list();

        FilterLogger logger = new FilterLoggerFile();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        if (liste != null){

            for(int i =0; i<liste.length;i++) {
                String pathIn = dirIn + "/" + liste[i];
                String pathOut = dirOut + "/" + liste[i];

                try {
                    Mat img = imread(pathIn);
                    for (Map.Entry<IFilter, Integer> entry : filtersOptions.entrySet()) {
                        img = entry.getKey().filter(img, entry.getValue());
                        String beginMessage = format.format(date)  + " => " + entry.getKey().logDescription(entry.getValue()) + " on " + liste[i];
                        logger.log(beginMessage + " from Directory " + dirInRac + " \t(" + dirIn + "). \t\t\tsave in directory " + dirOutRac + " \t(" +  dirOut + ").");
                    }
                    imwrite(pathOut, img);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }



    }
}

