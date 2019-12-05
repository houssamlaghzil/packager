package com.packager;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.io.FileNotFoundException;
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
        //program args:     -help -i src/main/java/imageIn -o src/main/java/imageOut -f blur:29|dilate:10|grayscale


        List<String> listCommandArgs = createCLI(args);
        Map<IFilter, Integer> filtersOptions = whichFilters( listCommandArgs );
        usingFilters(filtersOptions , listCommandArgs);

        dumpLog(listCommandArgs.get(3));


    }


    /**
     * this method generate the CLI and get all the information we need from the program arguments
     * @param args  the program arguments, you can defined them by editing Configuration
     * @return      List : a String list used to have the in directory , out directory and all the filters arguments
     */
    private static List<String> createCLI(String[] args){
        String dirIn=null;
        String dirOut=null;
        String filterArg=null;

        HelpFormatter formatter = new HelpFormatter();
        List<String> listCommandArgs = new ArrayList<>();
        String printLogger = "false";

        Options options = new Options();
        options.addOption("h", "help", false, "")
                .addOption("i", "input", true, "-dir <directory>")
                .addOption("o", "output", true, "-dir <directory>")
                .addOption("f", "filters", true, "filters options")
                .addOption("l", "logfile", false, "-file image.log")
        ;


        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("h")){
                System.out.println("help option was used");
                formatter.printHelp("imageFilter", options);
            }
            if(cmd.hasOption("i")){
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
            if(cmd.hasOption("l")){
                System.out.println("logger option selected ");
                printLogger = "true";
            }
        }catch (Exception e ){
            System.out.println(e);
        }

        OpenIni open = new OpenIni();
        try{
        List<String> listIni = open.openIni("src/config.ini");
        dirIn = listIni.get(0);
        dirOut = listIni.get(1);
        filterArg = listIni.get(2);
        }catch (Exception e){
            System.out.println(e);
        }



        listCommandArgs.add(dirIn);
        listCommandArgs.add(dirOut);
        listCommandArgs.add( filterArg);
        listCommandArgs.add( printLogger);


        return listCommandArgs;
    }



    /**
     * this method analyse the filters arguments from a List given in parameter, and create an HashMap with all the selected filters and their power
     * @param listCommandArgs   List : a String list used here to have all the filters arguments
     * @return                  Map : containing all filter's type and their effect's power
     */
    private static Map<IFilter, Integer> whichFilters(List<String> listCommandArgs){
        Map<IFilter, Integer> filtersOptions = new HashMap<>();
        int size = 0;
        FilterLogger logger = new FilterLoggerFile();

        String[] splitFilters = listCommandArgs.get(2).split("\\|");

        for (String s : splitFilters){

            String[] splitValue = s.split(":");
            switch (splitValue[0]){
                case "blur":
                    size = Integer.parseInt(splitValue[1]);
                    filtersOptions.put(new BlurFilter(),size);
                    logger.log( " you want to apply " + splitValue[0] +". value: " + splitValue[1]);
                    break;
                case  "grayscale":
                    filtersOptions.put(new BnWFilter(),size);
                    logger.log(" you want to apply " + splitValue[0]);
                    break;
                case  "dilate":
                    size = Integer.parseInt(splitValue[1]);
                    filtersOptions.put(new DilateFilter(),size);
                    logger.log( " you want to apply " + splitValue[0] +". value: " + splitValue[1]);
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
    private static void usingFilters(Map<IFilter, Integer> filtersOptions, List<String> listCommandArgs){
        String dirIn = listCommandArgs.get(0);
        String[] dirInTab = dirIn.split("/");
        String dirInRac = dirInTab[dirInTab.length-1];

        String dirOut = listCommandArgs.get(1);
        String[] dirOutTab = dirOut.split("/");
        String dirOutRac = dirOutTab[dirOutTab.length-1];

        File rep = new File(dirIn);
        String[] liste = rep.list();

        FilterLogger logger = new FilterLoggerFile();


        if (liste != null){

            for(int i =0; i<liste.length;i++) {
                String pathIn = dirIn + "/" + liste[i];
                String pathOut = dirOut + "/" + liste[i];

                try {
                    Mat img = imread(pathIn);
                    for (Map.Entry<IFilter, Integer> entry : filtersOptions.entrySet()) {
                        img = entry.getKey().filter(img, entry.getValue());
                        String beginMessage = " => " + entry.getKey().logDescription(entry.getValue()) + " on " + liste[i];
                        logger.log(beginMessage + " from Directory " + dirInRac + " \t(" + dirIn + "). \t\t\tsave in directory " + dirOutRac + " \t(" +  dirOut + ").");
                    }
                    imwrite(pathOut, img);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }


    /**
     * this method print the contents from AppFilter.log
     * @param printLogger   String : used to know if the user want to print the content or not
     */
    private static void dumpLog(String printLogger) {
        File f = new File("AppFilter.log");
        f.exists();

        if (printLogger.equals("true")) {
            try {
                Scanner myReader = new Scanner(f);
                System.out.println("opening file ...");
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}

