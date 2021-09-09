package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int AGE_LIMIT = 35;
    static final String NATIONALITY = "Ukrainian";
    static final int LIVING_IN_UKRAINE_LIMIT = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_LIMIT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])
                >= LIVING_IN_UKRAINE_LIMIT);
    }
}
