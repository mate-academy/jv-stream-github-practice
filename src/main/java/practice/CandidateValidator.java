package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int MIN_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final String YEARS_DIVIDER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedYears = candidate.getPeriodsInUkr().split(YEARS_DIVIDER);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(splitedYears[TO_YEAR_INDEX])
                - Integer.parseInt(splitedYears[FROM_YEAR_INDEX])) >= MIN_PERIOD;
    }
}
