package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LIMIT = 35;
    private static final int WAS_IN_UKR_LIMIT = 10;
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;
    private static final String SPLIT_ELEMENT = "-";
    private static final String CORRECT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] years = periodsInUkr.split(SPLIT_ELEMENT);
        int yearFrom = Integer.parseInt(years[YEAR_FROM]);
        int yearTo = Integer.parseInt(years[YEAR_TO]);
        int yearsWasInUkraine = yearTo - yearFrom;

        return candidate.getAge() >= AGE_LIMIT && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CORRECT_NATIONALITY)
                && yearsWasInUkraine > WAS_IN_UKR_LIMIT;
    }
}
