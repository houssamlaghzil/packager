package com.packager;

import org.bytedeco.opencv.opencv_core.*;

import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_core.*;

import org.bytedeco.opencv.opencv_core.Size;


public class BlurFilter<image> {

    /**
     * flou
     * @param filename
     */
    public static void smooth(String filename) {

        Mat image = imread(filename);//Open file OpenCV format
        if (image != null) {
            GaussianBlur(image, image, new Size(29, 29), 0);//flou img
            imwrite(filename, image);//save img flou
        }
        else
        {
            System.out.println("can't open this file");
        }


        }

    }