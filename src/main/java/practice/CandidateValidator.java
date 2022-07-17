package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String [] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int[] ints = Arrays.stream(periodsInUkr)
                .flatMapToInt(i -> IntStream.of(Integer.parseInt(i))).toArray();
        return ints[1] - ints[0] > 10 ? true : false;
    }
}
