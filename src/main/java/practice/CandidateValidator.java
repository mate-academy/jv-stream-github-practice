package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {

        int liveInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                 .map(Integer::parseInt)
                 .reduce((s1,s2) -> s2 - s1)
                 .map(Math::abs)
                 .get();
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && liveInUkraine >= 10
                && candidate.isAllowedToVote();
    }
}
