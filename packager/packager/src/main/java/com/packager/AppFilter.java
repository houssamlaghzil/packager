package com.packager;

<<<<<<< Updated upstream
import java.util.Scanner;

public abstract class AppFilter {
=======
import java.io.File;

public class AppFilter {
>>>>>>> Stashed changes
    public static void main(String[] args) {

        String chemin =  "/Users/franceebbasta/Desktop/AllPicturs/plage.jpg";
        BlurFilter blurFilter = new BlurFilter();
        blurFilter.smooth(chemin);


        System.out.println("application has started");
        print("|------------ MENU ------------|");
        print("|         0 - blur             |");
        print("|         1 - BnWfilter        |");
        print("|         2 - DikateFilter     |");
        print("|         3 - exite            |");
        print("|------------------------------|");
    }

<<<<<<< Updated upstream
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
=======
        System.out.println("application has started");
>>>>>>> Stashed changes

        BlurFilter file = new BlurFilter();
        //file.Smoother("geraltderiv.jpg");
        File dir = new File("gwen/Macintosh HD/Utilisateurs/Gwenael/Bureau/packager/PictureBefore");

<<<<<<< Updated upstream
            } else if (filter.equals("1")) {
                print("BnWFilter");
                new BnWFilter();

            } else if (filter.equals("2")) {
                print("DilateFilter");
=======
        System.out.println(dir.isDirectory());
        BlurFilter file2 = new BlurFilter();
        file2.loadAndShowOrExit("/Users/Gwenael/Desktop/packager/PictureBefore/geraltderiv.jpg");
>>>>>>> Stashed changes

        String chemin =  "/Users/franceebbasta/Desktop/AllPicturs/plage.jpg";
        BlurFilter blurFilter = new BlurFilter();
        blurFilter.smooth(chemin);

            }
        }
        print("okey bye");
    }
}
