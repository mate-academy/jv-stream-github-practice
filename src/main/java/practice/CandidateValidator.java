package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_OF_RESIDENCE_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int LIVED_IN_COUNTRY_FOR_YEAR = 0;
    private static final int LIVED_IN_COUNTRY_TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && liveInUkraineForYears(candidate) >= MIN_PERIOD_OF_RESIDENCE_UKRAINE;
    }

    private int liveInUkraineForYears(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] years = periodsInUkr.split("-");
        int yearFrom = Integer.parseInt(years[LIVED_IN_COUNTRY_FOR_YEAR]);
        int yearTo = Integer.parseInt(years[LIVED_IN_COUNTRY_TO_YEAR]);
        return yearTo - yearFrom;
    }
}
