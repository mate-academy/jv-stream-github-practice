package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLIT_SYMBOL = "-";
    private static final int REQUIRED_MIN_AGE = 35;
    private static final int REQUIRED_MIN_PERIOD = 10;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getPeriodInUkraine(candidate) >= REQUIRED_MIN_PERIOD;
    }

    private int getPeriodInUkraine(Candidate candidate) {
        String[] fromAndToYears = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        int fromYear = Integer.parseInt(fromAndToYears[START_YEAR]);
        int toYear = Integer.parseInt(fromAndToYears[END_YEAR]);
        return toYear - fromYear;
    }
}
