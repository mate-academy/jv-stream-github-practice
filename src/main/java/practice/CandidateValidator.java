package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_CANDIDATE_AGE = 35;
    public static final int MIN_AMOUNT_OF_YEARS_LIVING_IN_UKRAINE = 10;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int yearsInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsInUkraine >= MIN_AMOUNT_OF_YEARS_LIVING_IN_UKRAINE;
    }
}
