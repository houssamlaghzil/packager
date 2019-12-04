package com.packager;

import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import org.bytedeco.opencv.opencv_core.Size;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;


public class BlurFilter implements IFilter{



    @Override
    public void filter(String fileIn, String fileOut) throws FilterException {
        Mat img = imread(fileIn);
        int size = 3;
        if(size%2==1) {
            Mat result = img.clone();
            GaussianBlur(img, result, new Size(size, size), 0);
            imwrite(fileOut, img);
        }
        else{
            throw new FilterException("you don't have enter a good size value");


        }

    }
}
