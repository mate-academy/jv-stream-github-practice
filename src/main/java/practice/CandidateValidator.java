package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_LIVING_TERM = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote()
                && getYearsLivedInUkraine(candidate.getPeriodsInUkr()) >= MIN_LIVING_TERM;
    }

    private int getYearsLivedInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(",");
        int totalYears = 0;
        for (String period : periods) {
            String[] years = period.split("-");
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            totalYears += endYear - startYear;
        }
        return totalYears;
    }
}
