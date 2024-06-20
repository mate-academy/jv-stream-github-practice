package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
  public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!"Ukrainian".equalsIgnoreCase(candidate.getNationality())) {
            return false;
        }
        return livedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineForTenYears(String periodsInUkr) {
        String[] periods = periodsInUkr.split(",");
        int totalYears = 0;

        for (String period : periods) {
            String[] years = period.split("-");
            if (years.length == 2) {
                int startYear = Integer.parseInt(years[0]);
                int endYear = Integer.parseInt(years[1]);
                totalYears += (endYear - startYear);
            }
        }
        return totalYears >= 10;
    }
}
