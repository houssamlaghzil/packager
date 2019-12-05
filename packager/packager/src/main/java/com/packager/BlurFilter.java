package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

/**
 * this class could be used to apply a blur filter on an image opened as a matrix
 */
public class BlurFilter implements IFilter{

    /**
     * this method apply a Gaussian blur on a selected Matrix
     * @param img       Mat : matrix from an image
     * @param size      int : need to be impair to use this method. it represent the effect's power: higher it is, hazier it will be
     * @return          Mat : matrix after modification
     * @throws FilterException      : throws when size isn't impair
     */
    public Mat filter(Mat img, int size) throws FilterException {

        if(size%2==1) {
            GaussianBlur(img, img, new Size(size, size), 0);
        }
        else{
            throw new FilterException("you don't have enter a good size value");
        }
        return img;
    }
}

