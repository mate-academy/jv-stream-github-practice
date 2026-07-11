package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";

    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr()
                .split(PERIOD_SEPARATOR);

        int startYear = Integer.parseInt(years[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(years[END_YEAR_INDEX]);
        int yearsInUkraine = endYear - startYear + 1;

        return candidate.getAge() >= MIN_AGE
                    && candidate.isAllowedToVote()
                    && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                    && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
