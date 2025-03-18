package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ukr = "Ukrainian";
    private static final int period = 10;
    private static final int years = 2;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
            && candidate.isAllowedToVote()
            && candidate.getNationality().equalsIgnoreCase(ukr)
            && isEligiblePeriod(candidate.getPeriodsInUkr());
    }

    public boolean isEligiblePeriod(String periodsUkr) {
        String[] periods = periodsUkr.split("-");
        if (periods.length == years) {
            int startYear = Integer.parseInt(periods[0]);
            int endYear = Integer.parseInt(periods[1]);
            return (endYear - startYear) >= period;
        }
        return false;
    }
}
