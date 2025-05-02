package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String HYPHEN_FOR_SPLIT = "-";
    private static final int CANDIDATE_MINIMUM_AGE = 35;
    private static final int MIN_TIME_LIVED_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitCandidate = candidate.getPeriodsInUkr().split(HYPHEN_FOR_SPLIT);
        return candidate.getAge() >= CANDIDATE_MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && Integer.parseInt(splitCandidate[1])
                - Integer.parseInt(splitCandidate[0]) >= MIN_TIME_LIVED_IN_UKRAINE;
    }
}
