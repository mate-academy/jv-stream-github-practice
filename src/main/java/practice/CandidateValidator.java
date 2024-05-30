package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRE_MIN_AGE = 35;
    private static final int REQUIRE_LIVING = 10;
    private static final int START_LIVING = 0;
    private static final int CURRENT_LIVING = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRE_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isLengthOfLivingSuitable(candidate);
    }

    private boolean isLengthOfLivingSuitable(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[CURRENT_LIVING]) - Integer.parseInt(years[START_LIVING])
                >= REQUIRE_LIVING;
    }
}
