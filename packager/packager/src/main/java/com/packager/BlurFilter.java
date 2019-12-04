package com.packager;

import org.bytedeco.opencv.opencv_core.*;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

import org.bytedeco.opencv.opencv_core.Size;


public class BlurFilter {

    public Mat filterBlur(Mat image) {
        int size = 3;
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }

}