package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_APPLYING = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEAR_LIVING_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(periodsInUkraine[1])
                - Integer.parseInt(periodsInUkraine[0]);
        return candidate.getAge() >= MIN_AGE_FOR_APPLYING
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsInUkraine >= MIN_YEAR_LIVING_IN_UKRAINE;
    }
}

