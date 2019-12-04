package com.packager;

import org.bytedeco.opencv.opencv_core.*;

import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_core.*;

import org.bytedeco.opencv.opencv_core.Size;


public class BlurFilter<image> {

    public void smooth(String filename) {
        Mat image = imread(filename);
        if (image != null) {
            GaussianBlur(image, image, new Size(3, 3), 0);
            imwrite(filename, image);
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
<<<<<<< Updated upstream
=======
            Mat image = imread("/Users/tchydemianmarie/Desktop/packager/packager/packager/src/main/java/com/packager/imgin");//Open file OpenCV format
            if (image != null) {
                GaussianBlur(image, image, new Size(3, 3), 0);//flou img
                imwrite("/Users/tchydemianmarie/Desktop/packager/packager/packager/src/main/java/imgout", image);//save img flou
            }


        }




>>>>>>> Stashed changes
    }
}