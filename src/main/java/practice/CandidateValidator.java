package practice;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEAR_SEPARATOR = "-";
    private static final int MIN_AGE = 35;
    private static final int YEAR_START_INDEX = 0;
    private static final int YEAR_END_INDEX = 1;
    private static final int LIVE_REQUIREMENT = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEAR_SEPARATOR);
        if (years.length != 2) {
            throw new NoSuchElementException("Parse error for checking candidates leaving period");
        }
        int yearInUkraine = Integer.parseInt(years[YEAR_END_INDEX])
                - Integer.parseInt(years[YEAR_START_INDEX]);

        return yearInUkraine >= LIVE_REQUIREMENT;
    }
}
