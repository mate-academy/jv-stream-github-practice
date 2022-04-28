package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_CANDIDATES_AGE = 35;
    private static final String CANDIDATES_NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {

        return candidate.getAge() >= MAX_CANDIDATES_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATES_NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]) >= PERIOD_IN_UKRAINE;
    }
}
