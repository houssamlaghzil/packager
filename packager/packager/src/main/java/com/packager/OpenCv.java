package com.packager;

import org.bytedeco.opencv.opencv_core.*;


import static org.bytedeco.opencv.global.opencv_imgproc.*;

import static org.bytedeco.opencv.global.opencv_imgcodecs.*;


public class OpenCv {

    /**
     * flou
     * @param filename
     */
        public static void loadAndShowOrExit(String filename) {
            Mat image = imread(filename);//Open file OpenCV format
            if (image != null) {
                GaussianBlur(image,image, new Size(3, 3), 0);//flou img
                imwrite(filename, image);//save img flou
            }

        }


    }
    

