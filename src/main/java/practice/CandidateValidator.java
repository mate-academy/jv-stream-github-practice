package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int PERIODS_IN_UKR = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= PERIODS_IN_UKR;
    }

    private int calculateYearsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");
        int startYear = Integer.parseInt(periods[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(periods[END_YEAR_INDEX]);
        return endYear - startYear;
    }
}
