package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;

public interface IFilter {
    public  void filter(String fileIn, String fileOut);
}
