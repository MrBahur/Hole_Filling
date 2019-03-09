package Interface;

import ImageHandle.HoleFiller;
import ImageHandle.HoleFillerEightConnected;
import ImageHandle.HoleFillerFourConnected;
import ImageHandle.MyImage;
import NumericFunctions.Function;
import NumericFunctions.WeightedAverage;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.Scanner;

public class Main {
    private Function w;
    private double z;
    private double epsilon;
    private boolean fourConnected;
    private HoleFiller holeFiller;
    private Converter converter;
    private double[][] image;

    public Main() {
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.printWelcomeMessage();
        m.getParametersFromClient();
        m.getImageAndMaskFromClient();
        m.fixImage();
        m.saveImage();
    }

    private void saveImage() {
        Mat image = this.converter.doubleToImage(this.image);
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("how do you want to call your fixed image?");
        name = scanner.next();
        Imgcodecs.imwrite(name,image);
    }

    private void fixImage() {
        try {
            MyImage image = new MyImage(this.image);
            this.holeFiller.fillHole(image);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void getImageAndMaskFromClient() {
        Scanner scanner = new Scanner(System.in);
        String imagePath;
        String maskPath;
        Mat image;
        Mat mask;
        boolean gotImages = true;
        do {
            System.out.print("Please insert path for the image: ");
            imagePath = scanner.next();
            System.out.print("Please insert path for the mask\n " +
                    "make sure that the mask and the image are the same size\n" +
                    "and the the hole pixels are black: ");
            maskPath = scanner.next();
            image = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);
            mask = Imgcodecs.imread(maskPath, Imgcodecs.IMREAD_GRAYSCALE);
            if (image.rows() != mask.rows() || image.cols() != mask.rows()) {
                System.out.println("image and mask size are different please try again");
                gotImages=false;
            }
        }while (!gotImages);
        this.image=this.converter.makeHoleInImage(image,mask);
    }


    private void printWelcomeMessage() {
        System.out.println(" _   _       _                ______ _ _ _           \n" +
                "| | | |     | |               |  ___(_) | |          \n" +
                "| |_| | ___ | | ___   ______  | |_   _| | | ___ _ __ \n" +
                "|  _  |/ _ \\| |/ _ \\ |______| |  _| | | | |/ _ \\ '__|\n" +
                "| | | | (_) | |  __/          | |   | | | |  __/ |   \n" +
                "\\_| |_/\\___/|_|\\___|          \\_|   |_|_|_|\\___|_|   \n" +
                "                                                     \n" +
                "                                                     ");
        System.out.println("Hello and welcome to Hole - Filler Version 1.0");
        System.out.println("Made By Matan Anavi");

    }

    private void getParametersFromClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert Z value: ");
        this.z = scanner.nextDouble();
        do {
            System.out.print("Please insert epsilon value: ");
            this.epsilon = scanner.nextDouble();
            if (this.epsilon <= 0) {
                System.out.println("Illegal value for epsilon, must be greater then zero");
            }
        } while (this.epsilon <= 0);
        System.out.print("Please insert connectivity type (4 for four connected and 8 for eight connected: ");
        this.fourConnected = 4 == scanner.nextInt();
        try {
            this.w = new WeightedAverage(this.z, this.epsilon);
            if (fourConnected) {
                this.holeFiller = new HoleFillerFourConnected(this.w);
            } else {
                this.holeFiller = new HoleFillerEightConnected(this.w);
            }
            this.converter = new Converter();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
