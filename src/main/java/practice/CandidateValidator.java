package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    public static final int RESIDENT_DURATION = 10;
    public static final String PERIOD_DELIMITATION = "-";

    @Override
    public boolean test(Candidate candidate) {
        try {
            String[] periodYears = candidate.getPeriodsInUkr().split(PERIOD_DELIMITATION);
            if (periodYears.length != 2) {
                throw new RuntimeException();
            }
            return Integer.parseInt(periodYears[1]) - Integer.parseInt(periodYears[0])
                    >= RESIDENT_DURATION;
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid period in " + candidate.getPeriodsInUkr()
                    + " Only \"YYYY-YYYY\" format is accepted", e);
        }

    }
}
