package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int BORDER_AGE = 35;
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] str = candidate.getPeriodsInUkr().split("-");
        boolean isPeriodAcceptable = (Integer.parseInt(str[1])
                - Integer.parseInt(str[0])) >= MIN_PERIOD;
        return candidate.getAge() >= BORDER_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isPeriodAcceptable;
    }
}
