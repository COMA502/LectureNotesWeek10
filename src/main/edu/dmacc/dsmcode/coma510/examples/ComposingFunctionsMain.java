package edu.dmacc.dsmcode.coma510.examples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ComposingFunctionsMain {
    public static void main(String[] args) {
        /** Compose Function **/
//        Function<Object, String> objToString = o -> o.toString();
        Function<Object, String> objToString = Object::toString;
        Function<String, String> quote = s-> "\"" + s + "\"";

//        Function<Object, String> quoteObj = quote.compose(objToString);
        Function<Object, String> quoteObj = objToString.andThen(quote);
        System.out.println(quoteObj.apply(new Integer(5)));

        /** Compose BiFunction **/
        BiFunction<Integer, Integer, Integer> compareInt = Integer::compare;
        Function<Integer, Boolean> compareIsGreaterThan =
                compareResult -> compareResult > 0;
        BiFunction<Integer, Integer, Boolean> isGreaterThan =
                compareInt.andThen(compareIsGreaterThan);
        System.out.println("Is 1 greater than 2? " + isGreaterThan.apply(1, 2));
        System.out.println("Is 2 greater than 1? " + isGreaterThan.apply(2, 1));
    }
}
