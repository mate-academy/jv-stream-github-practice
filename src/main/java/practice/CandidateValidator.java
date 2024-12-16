package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PRESIDENT_ELIGIBILITY_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < PRESIDENT_ELIGIBILITY_AGE) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        if (!"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }

        String[] periods = candidate.getPeriodsInUkr().split(",");
        int totalYearInUkraine = Arrays.stream(periods)
                .mapToInt(period -> {
                    String[] range = period.trim().split("-");
                    int startYear = Integer.parseInt(range[0]);
                    int endYear = Integer.parseInt(range[1]);
                    return endYear - startYear + 1;
                })
                .sum();

        return totalYearInUkraine >= 10;
    }
}
