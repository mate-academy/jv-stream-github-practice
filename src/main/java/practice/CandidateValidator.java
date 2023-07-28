package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final String SEPARATOR = "-";
    private static final int FIRS_POSITION = 0;
    private static final int END_POSITION = 1;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && livesInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean livesInUkraineForTenYears(String periodsInUkr) {
        String[] years = periodsInUkr.split(SEPARATOR);
        int startYear = Integer.parseInt(years[FIRS_POSITION]);
        int endYear = Integer.parseInt(years[END_POSITION]);
        return (endYear - startYear) >= MIN_YEARS_IN_UKRAINE;
    }
}

