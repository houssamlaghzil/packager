package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class BlurFilter implements IFilter{

    public Mat filter(Mat img, int size) throws FilterException {
        //int size = 19;
        if(size%2==1) {
            GaussianBlur(img, img, new Size(size, size), 0);
        }
        else{
            throw new FilterException("you don't have enter a good size value");

        }
        return img;
    }
}

