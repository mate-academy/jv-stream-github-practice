package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String UKR_NATIONALITY = "Ukrainian";

    private boolean isEnoughPeriod(String period) {
        String[] fromToYears = period.split("-");
        int fromYear = Integer.parseInt(fromToYears[0]);
        int toYear = Integer.parseInt(fromToYears[1]);
        return toYear - fromYear > MIN_YEARS_IN_UKRAINE;
    }

    @Override
    public boolean test(Candidate candidate) {
        return isEnoughPeriod(candidate.getPeriodsInUkr())
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(UKR_NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
