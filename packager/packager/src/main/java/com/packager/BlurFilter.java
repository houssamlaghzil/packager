package com.packager;

import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_core.Size;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;


public class BlurFilter {
     
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


        /**
         * flou
         * @param filename
         */
            Mat image = imread(filename);//Open file OpenCV format
            if (image != null) {
                GaussianBlur(image, image, new Size(3, 3), 0);//flou img
                imwrite(filename, image);//save img flou
            }

        }