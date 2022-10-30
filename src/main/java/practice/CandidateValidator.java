package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final int PERIOD_IN_COUNTRY = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && isValidPeriod(candidate);
    }

    public boolean isValidPeriod(Candidate candidate) {
        String[] date = candidate.getPeriodsInUkr().split(REGEX);
        int yearFrom = Integer.parseInt(date[YEAR_FROM_INDEX]);
        int yearTo = Integer.parseInt(date[YEAR_TO_INDEX]);
        return yearTo - yearFrom >= PERIOD_IN_COUNTRY;
    }

}
