package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR_INDEX = 0;
    private static final String SPLITTER_FOR_YEARS = "-";
    private static final int TO_YEAR_INDEX = 1;
    private static final int VALID_FROM_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_YEARS_OF_PRESENCE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLITTER_FOR_YEARS);
        int yearsOfPresence = Integer.parseInt(years[TO_YEAR_INDEX])
                - Integer.parseInt(years[FROM_YEAR_INDEX]);
        return candidate.getAge() >= VALID_FROM_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && candidate.isAllowedToVote() && yearsOfPresence >= VALID_YEARS_OF_PRESENCE;
    }
}
