package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if ((candidate.getAge() >= 35) && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()) {
            Integer period = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                    .map(Integer::valueOf)
                    .reduce(0, (a, b) -> b - a);
            return period >= 10;
        }
        return false;
    }
}
