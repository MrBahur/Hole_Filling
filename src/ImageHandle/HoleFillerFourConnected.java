package ImageHandle;

import NumericFunctions.Function;
import NumericFunctions.WeightedAverage;
import javafx.util.Pair;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class HoleFillerFourConnected extends HoleFiller {

    public HoleFillerFourConnected(Function w) {
        super(w);
    }

    @Override
    void findHoleAndBoundary(MyImage image) {
        Set<Pair<Integer, Integer>> hole = image.getHole();
        Set<Pair<Integer, Integer>> boundary = image.getBoundary();
        double[][] imagePixels = image.getImage();
        for (int i = 0; i <imagePixels.length ; i++) {
            for (int j = 0; j <imagePixels.length ; j++) {
                if(imagePixels[i][j]==-1){
                    hole.add(new Pair<>(i,j));
                }
                else {
                    if(i+1<imagePixels.length&&imagePixels[i+1][j]==-1){
                        boundary.add(new Pair<>(i,j));
                    }
                    if(j-1>0&&imagePixels[i][j-1]==-1){
                        boundary.add(new Pair<>(i,j));
                    }
                    if(i-1>0&&imagePixels[i-1][j]==-1){
                        boundary.add(new Pair<>(i,j));
                    }
                    if(j+1<imagePixels[i].length&&imagePixels[i][j+1]==-1){
                        boundary.add(new Pair<>(i,j));
                    }
                }
            }

        }
    }

//    public static void main(String[] args) {
//        double[][] y = new double[100][100];
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j <100 ; j++) {
//                if(i>10 && i<15 && j>30 && j<35){
//                    y[i][j]=-1;
//                }
//                else{
//                    y[i][j]=0;
//                }
//            }
//        }
//
//        try{
//            MyImage x = new MyImage(y);
//            HoleFiller f= new HoleFillerFourConnected(new WeightedAverage());
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
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
