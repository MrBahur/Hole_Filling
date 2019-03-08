package NumericFunctions;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import javafx.util.Pair;
import org.opencv.core.Mat;
import org.opencv.core.Point;

import java.util.Vector;

public class WeightedAverage extends WeightFunction {
    private double z;
    private double epsilon;

    public WeightedAverage(double z, double epsilon) throws Exception{
        super(2);
        if(epsilon==0){
            throw new IllegalArgumentException("epsilon must be greater then 0");
        }
        this.z = z;
        this.epsilon = epsilon;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public WeightedAverage(double z)throws Exception {
        this(z,0.1);
    }

    public WeightedAverage()throws Exception {
        this(2);
    }

    @Override
    public double calculateResult(Pair <Double,Double>... arguments) throws Exception {
        checkInput(arguments);
        return (1/(Math.pow(distance(arguments[0],arguments[1]),z)+epsilon));
    }

    private double distance(Pair<Double,Double> x, Pair<Double,Double> y){
        return Math.pow((Math.pow(x.getKey()-y.getKey(),2)+Math.pow(x.getValue()-y.getValue(),2)),0.5);
    }


    private void checkInput(Pair<Double, Double>[] arguments) throws Exception{
        checkNumOfArguments(arguments);
        if(arguments==null||
                arguments[0]==null||arguments[1]==null||
                arguments[0].getKey()==null||arguments[0].getValue()==null||
                arguments[1].getKey()==null||arguments[1].getValue()==null)
        {
            throw new NullPointerException();
        }
    }

//    public static void main(String[] args) {
//        try {
//            WeightedAverage w = new WeightedAverage();
//            Pair<Double,Double> u = new Pair<>(0.0,0.0);
//            Pair<Double,Double> v = new Pair<>(0.0,2.0);
//            System.out.println(w.calculateResult(u,v));
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//
//        }
//    }
}
