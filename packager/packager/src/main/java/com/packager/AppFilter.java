package com.packager;

public class AppFilter {
    public static void main(String[] args) {
        String chemin =  "/Users/franceebbasta/Desktop/AllPicturs/plage.jpg";
        BlurFilter blurFilter = new BlurFilter();
        blurFilter.smooth(chemin);

    }
}
