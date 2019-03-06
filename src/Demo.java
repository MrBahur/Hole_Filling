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
        HighGui.namedWindow("check",HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("check",img);
        HighGui.waitKey();
        HighGui.destroyWindow("check");


        System.out.println("wait here");
    }
}