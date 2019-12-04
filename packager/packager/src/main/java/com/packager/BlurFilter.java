package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import org.bytedeco.opencv.opencv_core.Size;


public class BlurFilter implements IFilter{

    @Override

    public void filter(String fileIn, String fileOut) throws FilterException {
        Mat img = imread(fileIn);
        int size = 33;
        if(size%2==1) {
            GaussianBlur(img, img, new Size(size, size), 0);
            imwrite(fileOut, img);
        }
        else{
            throw new FilterException("you don't have enter a good size value");


        }
}
}
