package com.packager;

import org.bytedeco.opencv.opencv_core.*;
<<<<<<< HEAD
import org.bytedeco.opencv.opencv_core.Size;

public class BlurFilter {

    public static void blurFilter(String filename) {
=======
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;

public class BlurFilter {
    public static void smooth(String filename) {
>>>>>>> master
        Mat image = imread(filename);
        if (image != null) {
            GaussianBlur(image, image, new Size(3, 3), 0);
            imwrite(filename, image);
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

=======
>>>>>>> master
}