package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_BE_PRESIDENT = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int firstYear = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int secondYear = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        int periodInUkraine = secondYear - firstYear;
        return candidate.getAge() >= MIN_AGE_TO_BE_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && periodInUkraine >= MIN_PERIOD_IN_UKRAINE;
    }
}
