import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;


public class Demo{
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public static void main(String args[]){
        System.out.println(Core.VERSION);
        Mat img = Imgcodecs.imread("C:\\Users\\matan anavi\\Desktop\\programing\\Excercise\\Hole_Filling\\src\\test2.png",Imgcodecs.IMREAD_GRAYSCALE);
        Double [][] image = new Double[img.rows()][img.cols()];
        for (int i = 0; i <img.rows() ; i++) {
            for (int j = 0; j <img.cols() ; j++) {
                image[i][j]=img.get(i,j)[0]/255;
               // System.out.printf("%.2f ",image[i][j]);
            }
            System.out.println();
        }
        HighGui.namedWindow("image1",HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("image1",img);
        HighGui.waitKey(0);
        HighGui.destroyWindow("image1");

        Mat img2 = new Mat(image.length-1,image[0].length-1,Imgcodecs.IMREAD_GRAYSCALE);
        for (int i = 0; i <image.length ; i++) {
            for (int j = 0; j < image[i].length; j++) {
                double [] x = new double[1];
                x[0]=image[i][j]*255;
                img2.put(i,j,x);

            }
        }


        HighGui.namedWindow("image2",HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("image2",img2);
        HighGui.waitKey(0);
        HighGui.destroyWindow("image2");

    }
}