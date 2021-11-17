package practice;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        String[] strings = s.split("-");
        return Integer.parseInt(strings[1]) - Integer.parseInt(strings[0 ]) > 10;
    }
}
