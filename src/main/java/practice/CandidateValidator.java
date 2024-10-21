package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_IN_UKR = 10;
    private static final int MULTIPLE_PERIOD = 2;
    private static final int FIRST_POSITION = 0;
    private static final int SECOND_POSITION = 1;
    private static final int REQUIRED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && getYearsLivedInUkraine(candidate.getPeriodsInUkr()) >= REQUIRED_PERIOD_IN_UKR;
    }

    private int getYearsLivedInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(",");
        int totalYears = 0;
        for (String period : periods) {
            String[] years = period.trim().split("-");
            if (years.length == MULTIPLE_PERIOD) {
                int startYear = Integer.parseInt(years[FIRST_POSITION].trim());
                int endYear = Integer.parseInt(years[SECOND_POSITION].trim());
                totalYears += (endYear - startYear);
            }
        }
        return totalYears;
    }
}
