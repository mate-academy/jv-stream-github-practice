package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_VALIDATOR = "Ukrainian";
    private static final int VALID_YEARS_IN_UKRAINE = 10;
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        int yearsInUkraine = Integer.parseInt(periodsInUkraine[1])
                - Integer.parseInt(periodsInUkraine[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_VALIDATOR)
                && yearsInUkraine >= VALID_YEARS_IN_UKRAINE;
    }
}

