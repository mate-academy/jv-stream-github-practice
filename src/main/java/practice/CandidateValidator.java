package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";
    private static final int MIN_PERIOD_OF_RESIDENCE = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && getPeriodOfResidence(candidate) >= MIN_PERIOD_OF_RESIDENCE;
    }

    private int getPeriodOfResidence(Candidate candidate) {
        String[] arrWithYears = candidate.getPeriodsInUkr().split(REGEX);
        return Integer.parseInt(arrWithYears[1]) - Integer.parseInt(arrWithYears[0]);
    }
}
