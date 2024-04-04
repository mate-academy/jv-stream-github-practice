package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static int calculateYearsInUkraine(String periodsInUkr) {
        int totalYears = 0;
        String[] periods = periodsInUkr.split("-");
        if (periods.length == 2) {
            totalYears = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]) + 1;
        }
        return totalYears;

    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase("ukrainian")
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }
}
