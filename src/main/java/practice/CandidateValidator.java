package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int LEGAL_AGE = 35;
    private static final int NEEDED_YEARS_OF_LIVING = 10;
    private static final String NEEDED_NATIONALITY = "Ukrainian";
    private static final String DATA_DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] fromTo = candidate.getPeriodsInUkr().split(DATA_DELIMITER);
        boolean livedForTenYears =
                Integer.parseInt(fromTo[TO_YEAR_INDEX]) - Integer.parseInt(fromTo[FROM_YEAR_INDEX])
                        >= NEEDED_YEARS_OF_LIVING;
        return candidate.getAge() >= LEGAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NEEDED_NATIONALITY)
                && livedForTenYears;
    }
}
