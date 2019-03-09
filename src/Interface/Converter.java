package Interface;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Converter {

    public Mat doubleToImage(double[][] imagePixels) throws NullPointerException {
        if (imagePixels == null) {
            throw new NullPointerException();
        }
        Mat image = new Mat(imagePixels.length, imagePixels[0].length, Imgcodecs.IMREAD_GRAYSCALE);
        for (int i = 0; i < imagePixels.length; i++) {
            for (int j = 0; j < imagePixels[i].length; j++) {
                image.put(i, j, imagePixels[i][j] * 255);
            }
        }
        return image;
    }

    public double[][] imageToDouble(Mat image) {
        double[][] imagePixels = new double[image.rows()][image.cols()];
        for (int i = 0; i < image.rows(); i++) {
            for (int j = 0; j < image.cols(); j++) {
                imagePixels[i][j] = image.get(i, j)[0] / 255;
            }
        }
        return imagePixels;
    }

    public double[][] makeHoleInImage(Mat image, Mat mask) {//assuming the mask is the same size as image and that the hole pixels represented by black pixels
        double[][] imagePixels = new double[image.rows()][image.cols()];
        for (int i = 0; i < imagePixels.length; i++) {
            for (int j = 0; j < imagePixels[i].length; j++) {
                if (mask.get(i, j)[0] == 0) {
                    imagePixels[i][j] = -1;
                } else {
                    imagePixels[i][j] = image.get(i, j)[0]/255;
                }
            }
        }
        return imagePixels;
    }
}
