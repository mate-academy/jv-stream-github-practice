package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_AGE = 35;
    private static final int VISIT_UKRAINE_LIMIT = 10;
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] years = periodsInUkr.split(SEPARATOR);
        int yearFrom = Integer.parseInt(years[YEAR_FROM]);
        int yearTo = Integer.parseInt(years[YEAR_TO]);
        int yearsWasInUkraine = yearTo - yearFrom;

        return candidate.getAge() >= MAX_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsWasInUkraine >= VISIT_UKRAINE_LIMIT;
    }
}
