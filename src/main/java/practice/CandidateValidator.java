package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_PERIOD = 10;
    private static final int FROM = 0;
    private static final int TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] livingPeriod = candidate.getPeriodsInUkr().split("-");
        int livingPeriodResult = Integer.parseInt(livingPeriod[TO])
                - Integer.parseInt(livingPeriod[FROM]);
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && livingPeriodResult >= MIN_LIVING_PERIOD;
    }
}
