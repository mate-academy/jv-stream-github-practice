package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_AGE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEAR_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && hasLivedInUkraineEnough(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineEnough(String periodsInUkr) {
        String[] years = periodsInUkr.split(YEAR_SEPARATOR);
        int startYear = Integer.parseInt(years[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(years[END_YEAR_INDEX]);
        return (endYear - startYear) >= MIN_AGE_IN_UKRAINE;
    }
}

