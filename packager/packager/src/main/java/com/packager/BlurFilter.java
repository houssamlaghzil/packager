package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;


public class BlurFilter<image> {

    public void smooth(String filename) {
        Mat image = imread("file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgin/imgteste.png");
        if (image != null) {
            GaussianBlur(image, image, new Size(3, 3), 0);
            imwrite("file:///Users/souksou/Desktop/packager/packager/packager/src/main/java/com/packager/imgin", imgteste.png);
        }
    }

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
}