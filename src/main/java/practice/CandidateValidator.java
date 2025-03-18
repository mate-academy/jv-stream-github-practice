package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
            && candidate.isAllowedToVote()
            && candidate.getNationality().equalsIgnoreCase("Ukrainian")
            && isEligiblePeriod(candidate.getPeriodsInUkr());
    }

    public boolean isEligiblePeriod(String periodsUkr) {
        String[] periods = periodsUkr.split("-");
        if (periods.length == 2) {
            int startYear = Integer.parseInt(periods[0]);
            int endYear = Integer.parseInt(periods[1]);
            return (endYear - startYear) >= 10;
        }
        return false;
    }
}
