package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int ZERO_INDEX = 0;
    public static final int FIRST_INDEX = 1;
    public static final int MINIMUM_AGE_TO_BECOME_PRESIDENT = 35;

    public static final int MINIMUM_YEARS_TO_LIVE_IN_COUNTRY_TO_BECOME_PRESIDENT = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE_TO_BECOME_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase("ukrainian")
                && calculateYearsInUkraine(candidate.getPeriodsInUkr())
                >= MINIMUM_YEARS_TO_LIVE_IN_COUNTRY_TO_BECOME_PRESIDENT;
    }

    private static int calculateYearsInUkraine(String periodsInUkr) {
        int totalYears;
        String[] periods = periodsInUkr.split("-");
        totalYears = Integer.parseInt(periods[FIRST_INDEX]) - Integer.parseInt(periods[ZERO_INDEX])
                + FIRST_INDEX;
        return totalYears;
    }
}
