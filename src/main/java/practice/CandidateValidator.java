package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENT = 35;
    private static final int MIN_LIVING_IN_UKRAINE = 10;
    private static final String SUITABLE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(SUITABLE_NATIONALITY)
                && candidate.getAge() >= MIN_AGE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]))
                >= MIN_LIVING_IN_UKRAINE;
    }
}
