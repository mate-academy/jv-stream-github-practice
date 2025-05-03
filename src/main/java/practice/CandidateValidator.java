package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.parseInt(years[YEAR_FROM_INDEX]);
        int yearTo = Integer.parseInt(years[YEAR_TO_INDEX]);
        int periodInUkr = yearTo - yearFrom;
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodInUkr >= MIN_YEARS_IN_UKRAINE;
    }
}
