package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && getYearsLivedInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int getYearsLivedInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(",");
        int totalYears = 0;
        for (String period : periods) {
            String[] years = period.trim().split("-");
            if (years.length == 2) {
                int startYear = Integer.parseInt(years[0].trim());
                int endYear = Integer.parseInt(years[1].trim());
                totalYears += (endYear - startYear);
            }
        }
        return totalYears;
    }
}
