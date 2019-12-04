package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;


/**
 * Convertir une image en nuance de gris
 * @author Axel - ® fobec.com 2010
 */
public class BnWFilter implements IFilter{

    @Override
    public void filter(String fileIn, String fileOut) {
        Mat img = imread(fileIn);
        Mat result = new Mat(img.rows(), img.cols(), CvType.CV_8UC3);
        Imgproc.cvtColor(img, result, Imgproc.COLOR_GRAY2BGR, 3);
        imwrite(fileOut, img);
    }
}