package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(period[0]);
        int endYear = Integer.parseInt(period[1]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && (endYear - startYear) >= MIN_PERIOD;
    }
}
