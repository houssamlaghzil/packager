package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.bytedeco.opencv.global.opencv_imgproc.*;


public class BnWFilter implements IFilter{

    @Override
    public void filter(String fileIn, String fileOut) throws FilterException {
        Mat img = imread(fileIn);

        if (img != null) {
            Mat result = new Mat(img.rows(), img.cols(), CvType.CV_8SC3);
            cvtColor(img, result, Imgproc.COLOR_RGB2GRAY);
            imwrite(fileOut, result);
        } else {
            throw new FilterException("you haven't the good format ");
        }


    }

}