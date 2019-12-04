package com.packager;

<<<<<<< HEAD
public class DilateFilter {

    public static void dilateFilter(String args[]) {


=======

import org.bytedeco.opencv.opencv_core.*;
import org.opencv.imgproc.Imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;



<<<<<<< HEAD
    private Mat getStructuringElement(int morphRect, Size size) {
        return null;
>>>>>>> master
=======
public class DilateFilter implements IFilter {

    @Override

    public void filter(String fileIn, String fileOut) throws FilterException {
        Mat img = imread(fileIn);
        int size = 10;
        if (img != null) {
            Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
            dilate(img, img, element);
            imwrite(fileOut, img);
        } else {
            throw new FilterException("you haven't the good format ");
        }
<<<<<<< HEAD
>>>>>>> master
=======

>>>>>>> master
    }
}


