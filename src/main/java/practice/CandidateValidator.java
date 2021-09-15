package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T> implements Predicate<Candidate> {

    private static final String ALLOWED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        return candidate.isAllowedToVote()
                && (candidate.getAge() >= 35)
                && (candidate.getNationality().equals(ALLOWED_NATIONALITY))
                && (Integer.parseInt(periodsInUkr.substring(periodsInUkr.indexOf('-') + 1))
                - Integer.parseInt(periodsInUkr.substring(0, periodsInUkr.indexOf('-'))) >= 10);
    }
}
