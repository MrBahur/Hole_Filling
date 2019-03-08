package ImageHandle;

import NumericFunctions.WeightFunction;
import javafx.util.Pair;

import java.util.Set;

public abstract class HoleFiller {
    private WeightFunction w;

    public HoleFiller(WeightFunction w) {
        this.w = w;
    }

    abstract void findHoleAndBoundary(MyImage image);

    void fillHole(MyImage image) throws Exception {
        if (image == null) {
            throw new NullPointerException();
        }
        Set<Pair<Integer, Integer>> hole = image.getHole();
        if (hole.isEmpty()) {
            return;
        }
        Set<Pair<Integer, Integer>> boundary = image.getBoundary();
        if (boundary.isEmpty()) {
            throw new Exception("Shouldn't be able to get here, only for debug");
        }
        double[][] temp = image.getImage();
        for (Pair<Integer, Integer> pair : hole) {

            temp[pair.getKey()][pair.getValue()] = calculateIValue(pair, boundary, temp);
        }

    }

    private double calculateIValue(Pair<Integer,Integer> p, Set<Pair<Integer, Integer>> boundary, double[][] image) {
        double top = 0;
        double bot = 0;
        for (Pair<Integer, Integer> pair : boundary) {
            try {
                top += (w.calculateResult(p, pair)*image[pair.getKey()][pair.getValue()]);
                bot += w.calculateResult(p,pair);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return top/bot;
    }

}
