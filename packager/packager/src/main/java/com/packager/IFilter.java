package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;

public interface IFilter {
    public  Mat filter(Mat image) throws FilterException;


}
