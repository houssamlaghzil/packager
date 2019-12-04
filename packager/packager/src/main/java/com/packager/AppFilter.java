package com.packager;

import java.util.Scanner;

public abstract class AppFilter {
    public static void main(String[] args) {

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

}
