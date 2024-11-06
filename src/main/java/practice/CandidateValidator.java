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
        if (!"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }
        int yearsInUkraine = calculateYearsInUkraine(candidate.getPeriodsInUkr());
        return yearsInUkraine >= 10;
    }

    private int calculateYearsInUkraine(String periods) {
        String[] periodParts = periods.split("-");
        int startYear = Integer.parseInt(periodParts[0].trim());
        int endYear = Integer.parseInt(periodParts[1].trim());
        return endYear - startYear;
    }
}
