package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String YEAR_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }
        String[] years = candidate.getPeriodsInUkr().split(YEAR_SEPARATOR);
        int yearsInUkr = Integer.parseInt(years[END_YEAR_INDEX])
                - Integer.parseInt(years[START_YEAR_INDEX]);
        return yearsInUkr >= MIN_YEARS_IN_UKRAINE;
    }
}
