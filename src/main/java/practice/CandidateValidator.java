package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int VALID_DURATION_IN_UKRAINE = 10;
    private static final String GAP_SPLITTER = "-";
    private static final int INDEX_OF_START_LIVING_YEAR = 0;
    private static final int INDEX_OF_END_LIVING_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && isValidDuration(candidate);
    }

    private boolean isValidDuration(Candidate candidate) {
        String[] yearsOfLiving = candidate.getPeriodsInUkr().split(GAP_SPLITTER);
        return (Integer.parseInt(yearsOfLiving[INDEX_OF_END_LIVING_YEAR])
                - Integer.parseInt(yearsOfLiving[INDEX_OF_START_LIVING_YEAR]))
                >= VALID_DURATION_IN_UKRAINE;

    }
}
