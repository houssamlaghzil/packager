package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;


public class BlurFilter<image> {

    public void smooth(String filename) {
        Mat image = imread(filename);
        if (image != null) {
            GaussianBlur(image, image, new Size(33, 33), 0);
            imwrite(filename, image);
        }
        else
        {
            System.out.println("can't open this file");
        }


        }


}