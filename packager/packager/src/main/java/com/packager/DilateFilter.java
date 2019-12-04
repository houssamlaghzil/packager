package com.packager;


import org.bytedeco.opencv.opencv_core.*;
import org.opencv.imgproc.Imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;



public class DilateFilter implements IFilter{

    @Override
    public void filter(String fileIn, String fileOut) {
        Mat img = imread(fileIn);
        int size = 8;
        Mat result = img.clone();
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(img, result, element);
        imwrite(fileOut, img);
    }
}




