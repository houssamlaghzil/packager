package com.packager;

import org.bytedeco.opencv.opencv_core.*;

import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_core.*;

import org.bytedeco.opencv.opencv_core.Size;


public class BlurFilter<image> {

public class BlurFilter {
    public static void smooth(String filename) {
<<<<<<< HEAD
>>>>>>> master
        Mat image = imread(filename);
=======

    /**
     * flou
     * @param filename
     */
    public static void loadAndShowOrExit(String filename) {
        Mat image = imread(filename);//Open file OpenCV format
>>>>>>> Stashed changes
        if (image != null) {
            GaussianBlur(image,image, new Size(29, 29), 0);//flou img
            imwrite(filename, image);//save img flou
        }

    }
<<<<<<< HEAD
    private static void GaussianBlur(Mat image, Mat image1, Size size, int i) {
    }

    private static void imwrite(String filename, Mat image) {
    }

    private static Mat imread(String filename) {
        return null;
    }


    public void getImage() {
        Mat image = imread("file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgin/");//Open file OpenCV format
        if (image != null) {
            GaussianBlur(image, image, new Size(3, 3), 0);//flou img
            imwrite("file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgout/", image);//save img flou
        }


        /**
         * flou
         * @param filename
         */
    }
>>>>>>> master
