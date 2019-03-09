package NumericFunctions;

import javafx.util.Pair;

public interface Function {
    @SuppressWarnings("unchecked")
    double calculateResult(Pair<Integer, Integer>... arguments) throws Exception;
}
