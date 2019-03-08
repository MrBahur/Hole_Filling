package NumericFunctions;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

public abstract class WeightFunction implements Function{
    private int numOfArgs;

    WeightFunction(int numOfArgs)throws IllegalArgumentException {
        if (numOfArgs<0){
            throw new IllegalArgumentException("number of arguments must be greater or equal to zero");
        }
        this.numOfArgs = numOfArgs;
    }

    void checkNumOfArguments(Object[] args) throws WrongNumberArgsException {
        if(args.length!=numOfArgs){
            throw new WrongNumberArgsException(String.format("this function only receive %d arguments",numOfArgs));
        }
    }

}
