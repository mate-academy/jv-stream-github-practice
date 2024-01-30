package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String UKRAINIAN = "Ukrainian";
    private static final int VALID_AGE = 35;
    private static final int VALID_PERIOD_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatePeriodFromStartYearToEndYear = candidate.getPeriodsInUkr().split("-");
        int periodToInt = Integer.parseInt(candidatePeriodFromStartYearToEndYear[1])
                - Integer.parseInt(candidatePeriodFromStartYearToEndYear[0]);

        return (candidate.isAllowedToVote() && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(UKRAINIAN)
                && periodToInt > VALID_PERIOD_LIVE_IN_UKRAINE);
    }

}
