package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && hasTenYearsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean hasTenYearsInUkraine(String periods) {
        if (periods == null || periods.isEmpty()) {
            return false;
        }
        String[] years = periods.split("//-");
        if (years.length != 2) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            return endYear - startYear >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
