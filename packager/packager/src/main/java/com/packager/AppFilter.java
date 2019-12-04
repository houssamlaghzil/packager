package com.packager;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public abstract class AppFilter {

<<<<<<< HEAD
    public static void main(String[] args) {
        System.out.println("application has started");

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

            }

        } while (!actions.equals("3"));


    }
}
