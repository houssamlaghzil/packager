package com.packager;

<<<<<<< HEAD
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import static org.bytedeco.opencv.global.opencv_imgproc.*;
<<<<<<< HEAD
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;


public class BlurFilter<image> {

    public void smooth(String filename) {
        Mat image = imread(filename);
        if (image != null) {
            GaussianBlur(image, image, new Size(33, 33), 0);
            imwrite(filename, image);
        }
        else
        {
            System.out.println("can't open this file");
        }


        }

=======

=======
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
>>>>>>> master
import org.bytedeco.opencv.opencv_core.Size;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;


public class BlurFilter implements IFilter{



    @Override
    public void filter(String fileIn, String fileOut) throws FilterException {
        Mat img = imread(fileIn);
        int size = 3;
<<<<<<< HEAD
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }
>>>>>>> master
=======
        if(size%2==1) {
            Mat result = img.clone();
            GaussianBlur(img, result, new Size(size, size), 0);
            imwrite(fileOut, img);
        }
        else{
            throw new FilterException("you don't have enter a good size value");

>>>>>>> master

        }

    }
}
