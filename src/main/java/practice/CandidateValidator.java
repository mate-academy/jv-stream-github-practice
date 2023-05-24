package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_LIFETIME = 10;

    @Override
    public boolean test(Candidate candidate) {
        return VALID_NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && lifetimeInUkraine(candidate.getPeriodsInUkr()) >= VALID_LIFETIME;
    }

    private int lifetimeInUkraine(String periodsInUkr) {
        String[] splitYear = periodsInUkr.split("-");
        return Integer.parseInt(splitYear[1]) - Integer.parseInt(splitYear[0]);
    }
}
