package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int NEEDED_AGE = 35;
    private static final String NEEDED_NATIONALITY = "Ukrainian";
    private static final int NEEDED_YEARS_OF_LIVING = 10;
    private static final String DATA_DELIMITER = "-";
    private static final int TO_YEARS_INDEX = 1;
    private static final int FROM_YEARS_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsArray = candidate.getPeriodsInUkr().split(DATA_DELIMITER);
        boolean livedForTenYears =
                Integer.parseInt(periodsArray[TO_YEARS_INDEX])
                        - Integer.parseInt(periodsArray[FROM_YEARS_INDEX])
                        >= NEEDED_YEARS_OF_LIVING;
        return candidate.getAge() >= NEEDED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NEEDED_NATIONALITY)
                && livedForTenYears;
    }
}
