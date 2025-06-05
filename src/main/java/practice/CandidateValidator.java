package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        boolean ageCheck = candidate.getAge() >= 35;
        boolean voteCheck = candidate.isAllowedToVote();
        boolean nationalityCheck = "Ukrainian".equals(candidate.getNationality());
        boolean periodCheck = calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;

        return ageCheck && voteCheck && nationalityCheck && periodCheck;
    }

    private int calculateYearsInUkraine(String period) {
        if (period == null || !period.contains("-")) {
            return 0;
        }

        String[] parts = period.split("-");

        return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]);
    }
}
