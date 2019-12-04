package com.packager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AppFilter {
    public static void main(String[] args) {

        List<IFilter> filterArray = new ArrayList<>();
        filterArray.add(new BlurFilter());
        filterArray.add(new BnWFilter());
        filterArray.add(new DilateFilter());

    }
}

