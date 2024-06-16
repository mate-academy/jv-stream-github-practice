package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return forTest(candidate);
    }

    private static int calculateYearsInUkraine(String periods) {
        int totalYears = 0;
        if (periods.contains("-")) {
            String[] parts = periods.split("-");
            if (parts.length == 2) {
                int startYear = Integer.parseInt(parts[0]);
                int endYear = Integer.parseInt(parts[1]);
                totalYears = endYear - startYear;
            }
        }
        return totalYears;
    }

    private boolean forTest(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian" == candidate.getNationality()
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }
}
