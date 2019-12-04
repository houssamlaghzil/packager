package com.packager;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;



/**
 * Convertir une image en nuance de gris
 */
public class BnWFilter {

    public Mat BnWFilter(Mat image) {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        Imgproc.cvtColor(image, result, Imgproc.COLOR_RGB2HSV, 3);
        return result;
    }
}