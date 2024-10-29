package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && hasRequiredYearsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean hasRequiredYearsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(",");
        for (String period : periods) {
            String[] years = period.trim().split("-");
            if (years.length == 2) {
                int startYear = Integer.parseInt(years[0].trim());
                int endYear = Integer.parseInt(years[1].trim());
                if (endYear - startYear >= MIN_YEARS_IN_UKRAINE) {
                    return true;
                }
            }
        }
        return false;
    }
}
