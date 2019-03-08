package NumericFunctions;

import javafx.util.Pair;

public interface Function {
    double calculateResult(Pair<Double,Double>... arguments) throws Exception;
}
