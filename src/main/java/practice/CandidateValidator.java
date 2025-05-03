package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int LIVE_IN_UKRAINE_FOR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] fromYearToYearInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && Integer.parseInt(fromYearToYearInUkr[1])
                - Integer.parseInt(fromYearToYearInUkr[0]) >= LIVE_IN_UKRAINE_FOR;
    }
}
