package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int PERIODS_IN_UKRAINE = 10;
    private static final String REGEX = "-";
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(REGEX);
        int period = Integer.parseInt(periods[SECOND_ELEMENT])
                - Integer.parseInt(periods[FIRST_ELEMENT]);
        return candidate.getAge() >= CANDIDATE_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote()
                && period >= PERIODS_IN_UKRAINE;
    }
}
