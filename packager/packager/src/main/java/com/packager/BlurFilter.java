package com.packager;

import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import org.bytedeco.opencv.opencv_core.Size;


public class BlurFilter implements IFilter{



    @Override
    public void filter(String fileIn, String fileOut) {
        Mat img = imread(fileIn);
        int size = 3;
        Mat result = img.clone();
        GaussianBlur(img, result, new Size(size, size), 0);
        imwrite(fileOut, img);

    }
}
