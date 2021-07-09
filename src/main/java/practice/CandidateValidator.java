package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int MIN_CANDIDATES_AGE = 35;
    private static final int MIN_LIVING_PERIOD = 10;
    private static final String CANDIDATES_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATES_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATES_NATIONALITY)
                && validatePeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean validatePeriodInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split(SEPARATOR);
        return (Integer.parseInt(years[1]) - Integer.parseInt(years[0])) >= MIN_LIVING_PERIOD;
    }
}
