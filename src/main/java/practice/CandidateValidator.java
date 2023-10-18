package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int TEN_YEARS = 10;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String [] interval = candidate.getPeriodsInUkr().split("-");
        Integer startLivingInUkraine = Integer.parseInt(interval[ZERO]);
        Integer endLivingInUkraine = Integer.parseInt(interval[ONE]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && endLivingInUkraine - startLivingInUkraine >= TEN_YEARS;
    }

}
