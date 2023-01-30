package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_PRESIDENT = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVE_IN_UKRAINIAN = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_PRESIDENT
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(5)) - Integer
                .parseInt(candidate.getPeriodsInUkr()
                .substring(0, 4)) >= MIN_PERIOD_LIVE_IN_UKRAINIAN;
    }
}
