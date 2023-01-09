package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String DELIMITER = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(DELIMITER);
        int yearsInUkr = Integer.parseInt(periods[TO_YEAR_INDEX])
                - Integer.parseInt(periods[FROM_YEAR_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && NATIONALITY.equals(candidate.getNationality())
                && yearsInUkr >= MIN_YEARS_IN_UKRAINE;
    }
}
