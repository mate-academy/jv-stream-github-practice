package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int calculateYearsInUkraine(String periods) {
        int totalYears = 0;
        String[] parts = periods.split("-");
        if (parts.length == 2) {
            int startYear = Integer.parseInt(parts[0]);
            int endYear = Integer.parseInt(parts[1]);
            totalYears = endYear - startYear + 1;

        }
        return totalYears;
    }
}
