package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] livingPeriod = candidate.getPeriodsInUkr().split("-");
        int livingPeriodResult = Integer.parseInt(livingPeriod[1])
                - Integer.parseInt(livingPeriod[0]);
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && livingPeriodResult >= MIN_LIVING_PERIOD;
    }
}
