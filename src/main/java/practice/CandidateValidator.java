package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int PART_ONE = 0;
    private static final int PART_TWO = 1;
    private static final int TO_AGE = 35;
    private static final int DURATION_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split("-");
        int duration = Integer.parseInt(splitted[PART_TWO]) - Integer.parseInt(splitted[PART_ONE]);
        if (candidate.isAllowedToVote() && candidate.getAge() >= TO_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && duration >= DURATION_IN_UKRAINE) {
            return true;
        }
        return false;
    }
}
