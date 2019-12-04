package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;


public class BlurFilter<image> {

    public void smooth(String filename) {
        Mat image = imread(filename);
        if (image != null) {
            GaussianBlur(image, image, new Size(3, 3), 0);
            imwrite(filename, image);
        }
        else
        {
            System.out.println("can't open this file");
        }


        }

    }