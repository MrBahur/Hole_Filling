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
                image[i][j]=img.get(i,i)[0]/255;
                System.out.printf("%03f ",image[i][j]);
            }
            System.out.println();
        }




        /*
        HighGui.namedWindow("image",HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("image",img);
        HighGui.waitKey(0);
        HighGui.destroyWindow("image");
        */



    }
}