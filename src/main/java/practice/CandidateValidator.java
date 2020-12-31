package practice;

import model.Candidate;

import java.util.Arrays;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String [] strings = candidate.getPeriodsInUkr().split("-");
        int period = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .reduce((data1, data2) -> data2 - data1).getAsInt();
        return candidate.getAge() >= 35 && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote() && period >= 10;
    }
}
