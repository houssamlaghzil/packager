package com.packager;

<<<<<<< HEAD
<<<<<<< HEAD
public class DilateFilter {

    public static void dilateFilter(String args[]) {


=======

=======
>>>>>>> master
import org.bytedeco.opencv.opencv_core.*;
import org.opencv.imgproc.Imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

<<<<<<< HEAD
    private Mat getStructuringElement(int morphRect, Size size) {
        return null;
>>>>>>> master
=======
public class DilateFilter implements IFilter {
    @Override
    public Mat filter(Mat img) throws FilterException {
        int size = 10;
        if (img != null) {
            Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
            dilate(img, img, element);
        } else {
            throw new FilterException("you haven't the good format ");
        }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> master
=======

>>>>>>> master
=======
        return img;
>>>>>>> master
    }
}


