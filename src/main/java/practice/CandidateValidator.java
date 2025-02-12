package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    public static final int RESIDENT_DURATION = 10;
    public static final String PERIOD_DELIMITATION = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodYears = candidate.getPeriodsInUkr().split(PERIOD_DELIMITATION);
        return Integer.parseInt(periodYears[1]) - Integer.parseInt(periodYears[0])
                >= RESIDENT_DURATION;
    }
}
