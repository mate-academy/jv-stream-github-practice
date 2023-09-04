package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String SPLIT_DELIMITER = "-";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SPLIT_DELIMITER);
        int fromYear = Integer.parseInt(period[FROM_YEAR_INDEX]);
        int toYear = Integer.parseInt(period[TO_YEAR_INDEX]);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && toYear - fromYear >= YEARS_IN_UKRAINE;
    }
}
