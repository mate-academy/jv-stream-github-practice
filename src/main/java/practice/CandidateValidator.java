package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && findPeriodStayInUkr(candidate) >= 10
                && candidate.isAllowedToVote();
    }

    private int findPeriodStayInUkr(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        if (period.length == 2) {
            return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
        }
        return 0;
    }
}
