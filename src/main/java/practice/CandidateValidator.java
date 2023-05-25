package practice;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<String> {
    //write your code here
    @Override
   public boolean test(String string) {
        return string.equals("b") || string.equals("c");
    }
}
