package com.packager;


import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.dilate;

public class DilateFilter{

    public Mat filterDilate(Mat image) {
        int size = 8;
        Mat result = image.clone();
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(image, result, element);
        return result;
    }

    private Mat getStructuringElement(int morphRect, Size size) {
        return null;
    }
}




