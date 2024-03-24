package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LIMIT = 35;
    private static final int PERIODS = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int PRESENT_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_LIMIT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= PERIODS;
    }

    private int calculateYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        int startYear = Integer.parseInt(years[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(years[PRESENT_YEAR_INDEX]);
        return endYear - startYear;
    }
}
