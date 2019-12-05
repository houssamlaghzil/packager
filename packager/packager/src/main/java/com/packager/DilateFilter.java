package com.packager;

import org.bytedeco.opencv.opencv_core.*;
import org.opencv.imgproc.Imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.*;


public class DilateFilter implements IFilter {
    @Override
    public Mat filter(Mat img, int size) throws FilterException {
        //int size = 5;
        if (img != null) {
            Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
            dilate(img, img, element);
            return img;
        } else {
            throw new FilterException("you haven't the good format ");
        }

    }
}
