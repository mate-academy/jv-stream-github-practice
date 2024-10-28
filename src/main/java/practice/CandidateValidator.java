package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return isValid(candidate);
    }

    public boolean isValid(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && livedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineForTenYears(String periodsInUkr) {
        String[] periods = periodsInUkr.split(",");
        int totalYears = 0;

        for (String period : periods) {
            String[] years = period.split("-");
            if (years.length == 2) {
                int startYear = Integer.parseInt(years[0].trim());
                int endYear = Integer.parseInt(years[1].trim());
                totalYears += endYear - startYear + 1;
            }
        }
        return totalYears >= 10;
    }
}

