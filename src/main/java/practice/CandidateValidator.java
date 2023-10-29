package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int FROM = 0;
    private static final int TO = 1;
    private static final String NATION = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String [] interval = candidate.getPeriodsInUkr().split(SEPARATOR);
        int startLivingInUkraine = Integer.parseInt(interval[FROM]);
        int endLivingInUkraine = Integer.parseInt(interval[TO]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATION)
                && endLivingInUkraine - startLivingInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
