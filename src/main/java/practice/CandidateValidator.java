package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodYears = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= VALID_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && Integer.parseInt(periodYears[1])
                - Integer.parseInt(periodYears[0]) >= IN_UKRAINE;
    }
}
