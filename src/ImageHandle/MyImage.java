package ImageHandle;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class MyImage {
    private double[][] image;
    private Set<Pair<Integer, Integer>> hole;
    private Set<Pair<Integer, Integer>> boundary;

    public MyImage(double[][] image) throws Exception {

        if (image == null) {
            throw new NullPointerException();
        }

        this.image = image;
        hole = new HashSet<>();
        boundary = new HashSet<>();
    }

    public double[][] getImage() {
        return image;
    }

    public Set<Pair<Integer, Integer>> getHole() {
        return hole;
    }

    public Set<Pair<Integer, Integer>> getBoundary() {
        return boundary;
    }
}
