package com.packager;

import org.bytedeco.opencv.opencv_core.*;
import org.opencv.imgproc.Imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

/**
 * this class could be used to apply a Dilatation on an image opened as a matrix
 */
public class DilateFilter implements IFilter {

    /**
     * this method apply a dilating filter on a selected Matrix
     * @param img       Mat :  matrix from an image
     * @param size      int : it represent the effect's power: higher it is, more the effect will be important
     * @return          Mat : matrix after modification
     */
    @Override
    public Mat filter(Mat img, int size) {
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(img, img, element);
        return img;

    }

    @Override
    public String logDescription(int value) {
        return "applying dilate filter, \tvalue: " + value;
    }
}
