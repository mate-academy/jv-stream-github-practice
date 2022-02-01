package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final String nationality = "Ukrainian";
    private final int lowAge = 35;
    private final int liveInCountry = 10;

    @Override
    public boolean test(Candidate candidate) {

        int liveInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                 .map(Integer::parseInt)
                 .reduce((s1,s2) -> s2 - s1)
                 .map(Math::abs)
                 .get();
        return candidate.getAge() >= lowAge
                && candidate.getNationality().equals(nationality)
                && liveInUkraine >= liveInCountry
                && candidate.isAllowedToVote();
    }
}
