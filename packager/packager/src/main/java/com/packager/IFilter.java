package com.packager;

import org.bytedeco.opencv.opencv_core.Mat;

/**
 * this is an interface created for the various Filters
 */
public interface IFilter {

    /**
     * this method will apply a specific filter on a selected matrix
     * @param image     Mat : matrix from an image
     * @param size      int : it represent the effect's power, for methods that could use it
     * @return          Mat : matrix after modification
     * @throws FilterException
     */
    public  Mat filter(Mat image, int size) throws FilterException;

    public String logDescription(int value);


}
