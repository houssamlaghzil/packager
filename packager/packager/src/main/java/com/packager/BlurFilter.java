package com.packager;

import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_core.Size;

public class BlurFilter {

    public static void blurFilter(String filename) {
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

}