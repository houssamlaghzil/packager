package com.packager;

import java.util.Scanner;

public abstract class AppFilter {
    public static void main(String[] args) {
<<<<<<< HEAD

        System.out.println("application has started");
        print("|------------ MENU ------------|");
        print("|         0 - blur             |");
        print("|         1 - BnWfilter        |");
        print("|         2 - DikateFilter     |");
        print("|         3 - exite            |");
        print("|------------------------------|");
    }

    public static void print(Object o)     /** print shortcut method */
    {
        System.out.println(o);
    }



    public static void choiceFilter() {
        Scanner sc = new Scanner(System.in);
        String filter = sc.nextLine();

        while (!filter.equals("3")) {
            if (filter.equals("0")) {
                print("blur effct");


            } else if (filter.equals("1")) {
                print("BnWFilter");
                new BnWFilter();

            } else if (filter.equals("2")) {
                print("DilateFilter");

=======
        String chemin =  "/Users/franceebbasta/Desktop/AllPicturs/plage.jpg";
        BlurFilter blurFilter = new BlurFilter();
        blurFilter.smooth(chemin);
>>>>>>> master

            }
        }
        print("okey bye");
    }
}
