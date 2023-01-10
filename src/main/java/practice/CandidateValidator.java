package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_VALID_AGE = 35;
    private static final int MIN_VALID_PERIOD_OF_RESIDENCE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int FIRST_DATE_INDEX = 0;
    private static final int SECOND_DATE_INDEX = 1;
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodsInUkr = getPeriodOfLeaving(candidate);
        return candidate.getAge() >= MAX_VALID_AGE
                & candidate.isAllowedToVote()
                & candidate.getNationality().equals(REQUIRED_NATIONALITY)
                & periodsInUkr >= MIN_VALID_PERIOD_OF_RESIDENCE;
    }

    private int getPeriodOfLeaving(Candidate candidate) {
        int firstDate = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SPLIT_SYMBOL)[FIRST_DATE_INDEX]);
        int secondDate = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SPLIT_SYMBOL)[SECOND_DATE_INDEX]);
        return secondDate - firstDate;
    }
}
