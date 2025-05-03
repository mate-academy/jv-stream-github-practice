package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final String NATIONALITY = "Ukrainian";
    static final int LOW_AGE = 35;
    static final int LIVE_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {

        int liveInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                 .map(Integer::parseInt)
                 .reduce((s1,s2) -> s2 - s1)
                 .map(Math::abs)
                 .get();
        return candidate.getAge() >= LOW_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && liveInUkraine >= LIVE_IN_COUNTRY
                && candidate.isAllowedToVote();
    }
}
