package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static int MIN_VALID_AGE = 35;
    private final static String VALID_NATIONALITY = "Ukrainian";
    private final static int MIN_VALID_PERIODS = 10;
    private final static int FROM_YEAR_INDEX = 0;
    private final static int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && checkPeriodsInUkr(candidate);
    }

    private boolean checkPeriodsInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[TO_YEAR_INDEX])
                - Integer.parseInt(years[FROM_YEAR_INDEX]) >= MIN_VALID_PERIODS;
    }
}
