package ImageHandle;

import NumericFunctions.Function;
import NumericFunctions.WeightedAverage;
import javafx.util.Pair;

import java.util.Set;

public class HoleFillerEightConnected extends HoleFiller {

    public HoleFillerEightConnected(Function w) {
        super(w);
    }

    @Override
    void findHoleAndBoundary(MyImage image) {
        Set<Pair<Integer, Integer>> hole = image.getHole();
        Set<Pair<Integer, Integer>> boundary = image.getBoundary();
        double[][] imagePixels = image.getImage();
        for (int i = 0; i < imagePixels.length; i++) {
            for (int j = 0; j < imagePixels.length; j++) {
                if (imagePixels[i][j] == -1) {
                    hole.add(new Pair<>(i, j));
                } else {
                    boolean isBoundary = false;
                    if (i + 1 < imagePixels.length && imagePixels[i + 1][j] == -1) {
                        isBoundary = true;
                    }
                    if (!isBoundary && j - 1 > 0 && imagePixels[i][j - 1] == -1) {
                        isBoundary = true;
                    }
                    if (!isBoundary && i - 1 > 0 && imagePixels[i - 1][j] == -1) {
                        isBoundary = true;
                    }
                    if (!isBoundary && j + 1 < imagePixels[i].length && imagePixels[i][j + 1] == -1) {
                        boundary.add(new Pair<>(i, j));
                    }
                    if (!isBoundary && j - 1 > 0 && i - 1 > 0 && imagePixels[i - 1][j - 1] == -1) {
                        isBoundary = true;
                    }
                    if (!isBoundary && i - 1 > 0 && j + 1 < imagePixels[i].length && imagePixels[i - 1][j + 1] == -1) {
                        isBoundary = true;
                    }
                    if (!isBoundary && j - 1 > 0 && i + 1 < imagePixels[i].length && imagePixels[i + 1][j - 1] == -1) {
                        isBoundary = true;
                    }
                    if (!isBoundary && i + 1 < imagePixels[i].length && j + 1 < imagePixels[i].length && imagePixels[i + 1][j + 1] == -1) {
                        isBoundary = true;
                    }
                    if (isBoundary) {
                        boundary.add(new Pair<>(i, j));
                    }
                }
            }

        }
    }
//        public static void main(String[] args) {
//        double[][] y = new double[50][50];
//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j <50 ; j++) {
//                if(i>10 && i<15 && j>30 && j<35){
//                    y[i][j]=-1;
//                }
//                else{
//                    y[i][j]=Math.random();
//                }
//            }
//        }
//
//        try{
//            MyImage x = new MyImage(y);
//            HoleFiller f= new HoleFillerEightConnected(new WeightedAverage());
//            f.findHoleAndBoundary(x);
//            System.out.println("Hole:\n-------------------------------");
//            for (Pair p:x.getHole() ) {
//                System.out.println("x:"+p.getKey()+"   y:"+p.getValue());
//            }
//            System.out.println("Boundary:\n-------------------------------");
//            for (Pair p:x.getBoundary()) {
//                System.out.println("x:"+p.getKey()+"   y:"+p.getValue());
//            }
//
//            double[][] d = x.getImage();
//            System.out.println("before:");
//            for (int i = 0; i <50 ; i++) {
//                for (int j = 0; j <50 ; j++) {
//                    System.out.printf("%.2f ",d[i][j]);
//                }
//                System.out.println();
//            }
//            f.fillHole(x);
//            System.out.println("after");
//            for (int i = 0; i <50 ; i++) {
//                for (int j = 0; j <50 ; j++) {
//                    System.out.printf("%.2f ",d[i][j]);
//                }
//                System.out.println();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
