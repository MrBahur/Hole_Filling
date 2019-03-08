package NumericFunctions;

import javafx.util.Pair;

public interface Function {
    double calculateResult(Pair<Integer,Integer>... arguments) throws Exception;
}
