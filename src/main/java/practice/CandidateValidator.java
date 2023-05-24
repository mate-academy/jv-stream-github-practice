package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final int PERIOD_MIN = 10;
    private static final int PERIOD_START_INDEX = 0;
    private static final int PERIOD_END_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriodInYears(candidate.getPeriodsInUkr()) >= PERIOD_MIN;
    }

    private int getPeriodInYears(String period) {
        String[] periodsInUkrArray = period.split(SEPARATOR);
        return Integer.parseInt(periodsInUkrArray[PERIOD_END_INDEX])
                - Integer.parseInt(periodsInUkrArray[PERIOD_START_INDEX]);
    }
}
