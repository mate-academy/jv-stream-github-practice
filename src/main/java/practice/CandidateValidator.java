package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()
                || !candidate.getNationality().equals(REQUIRED_NATIONALITY)
                || candidate.getAge() < MIN_REQUIRED_AGE) {
            return false;
        }

        String[] split = candidate.getPeriodsInUkr().split("-");
        if (split.length != 2) {
            throw new IllegalArgumentException("Invalid period format: "
                    + candidate.getPeriodsInUkr());
        }

        int startYear = Integer.parseInt(split[0]);
        int endYear = Integer.parseInt(split[1]);
        return (endYear - startYear) >= 10;
    }
}
