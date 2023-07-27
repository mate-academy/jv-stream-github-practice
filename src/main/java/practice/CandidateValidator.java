package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int VALID_DURATION_IN_UKRAINE = 10;
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() <= VALID_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && isValidDuration(candidate);
    }

    private boolean isValidDuration(Candidate candidate) {
        String[] yearsOfLiving = candidate.getPeriodsInUkr().split(SPLITTER);
        return (Integer.parseInt(yearsOfLiving[1]) - Integer.parseInt(yearsOfLiving[0]))
                >= VALID_DURATION_IN_UKRAINE;

    }
}
