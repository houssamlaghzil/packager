package com.packager;


import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.util.ArrayList;
=======
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
>>>>>>> master
import java.util.Scanner;
import java.io.File;
=======

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

>>>>>>> master

public abstract class AppFilter {

<<<<<<< HEAD
    public static void main(String[] args) {
        System.out.println("application has started");

<<<<<<< HEAD
        chooseFilter();

=======
        System.out.println("application has started");
        print("|------------ MENU ------------|");
        print("|         0 - blur             |");
        print("|         1 - BnWfilter        |");
        print("|         2 - DikateFilter     |");
        print("|         3 - exite            |");
        print("|------------------------------|");
>>>>>>> master
    }


    public static void print(Object o)     /** print shortcut method */
    {
        System.out.println(o);
    }

<<<<<<< HEAD

<<<<<<< HEAD
    public static void chooseFilter() {
=======
    public static void choiceFilter() {
>>>>>>> master
        Scanner sc = new Scanner(System.in);
        String actions;
        ArrayList commandList = new ArrayList();

        commandList.add("blur_effect");
        commandList.add("bnw_effect");
        commandList.add("dilate_effect");
        commandList.add("exit");

        System.out.println("application has started");
        print("|------------ MENU ------------|");
        print("|         0 - blur_effect      |");
        print("|         1 - BnW_effect       |");
        print("|         2 - dilate_effect    |");
        print("|         3 - exit             |");
        print("|------------------------------|");

        do{
            actions = sc.nextLine();

            if (actions.equals("0") || actions.equals(commandList.get(0))) {
                print("applying blur effect");
                BlurFilter file = new BlurFilter();
                String filePath = "/Users/Gwenael/Desktop/packager/PictureBefore/geraltderiv.jpg";
                file.smooth(filePath);
            }
            else if (actions.equals("1") || actions.equals(commandList.get(1))){
                print("applying Black and White effect");

<<<<<<< HEAD
            }
            else if (actions.equals("2") || actions.equals(commandList.get(2))){
                print("applying Dilate effect");
=======
        String chemin =  "/Users/franceebbasta/Desktop/AllPicturs/plage.jpg";
        BlurFilter blurFilter = new BlurFilter();

>>>>>>> master
=======
        List<IFilter> filterArray = new ArrayList<>();
        filterArray.add(new BlurFilter());
        filterArray.add(new BnWFilter());
        filterArray.add(new DilateFilter());
=======
import java.io.File;
>>>>>>> master
=======
>>>>>>> master

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

<<<<<<< HEAD
        } while (!actions.equals("3"));

=======
        }
        else{
            System.err.println("nom invalide");
        }
<<<<<<< HEAD
>>>>>>> filterStory5
>>>>>>> master
=======

>>>>>>> master

    }
}

