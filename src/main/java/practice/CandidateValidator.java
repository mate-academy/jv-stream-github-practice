package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY_FILTER = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String YEAR_SEPARATOR = "-";

    @Override
    public boolean test(Candidate c) {
        String[] years = c.getPeriodsInUkr().split(YEAR_SEPARATOR);
        int yearsInUkr = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);

        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && NATIONALITY_FILTER.equals(c.getNationality())
                && yearsInUkr >= MIN_YEARS_IN_UKRAINE;

    }
}
