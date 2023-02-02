package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String REQUIRED_CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_CANDIDATE_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_CANDIDATE_NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[1])
                - (Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[0])))
                >= REQUIRED_CANDIDATE_PERIOD_IN_UKRAINE;
    }
}
