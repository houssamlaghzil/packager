package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.*;


public class BnWFilter implements IFilter {

    @Override
    public Mat filter(Mat img, int size) throws FilterException {
        if (img != null) {
            Mat result = new Mat(img.rows(), img.cols(), CvType.CV_8SC3);
            cvtColor(img, result, Imgproc.COLOR_RGB2GRAY);
            return result;
        } else {
            throw new FilterException("you haven't the good format ");
        }

    }
}
