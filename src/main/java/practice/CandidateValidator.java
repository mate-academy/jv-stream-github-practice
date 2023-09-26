package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        // Check if the candidate meets the eligibility criteria
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        if (years.length != 2) {
            return false;
        }
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        int totalYears = endYear - startYear + 1;
        return totalYears >= 10;
    }
}
