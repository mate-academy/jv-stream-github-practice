package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null || !candidate.isAllowedToVote()
                || !"Ukrainian".equals(candidate.getNationality())
                || candidate.getAge() < MIN_AGE) {
            return false;
        }
        String periodsInUkr = candidate.getPeriodsInUkr();
        if (periodsInUkr == null || !periodsInUkr.contains("-")) {
            return false;
        }
        String[] period = periodsInUkr.split("-");
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]) >= MIN_PERIOD;
    }
}
