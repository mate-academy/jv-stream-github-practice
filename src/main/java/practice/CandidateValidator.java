package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRE_AGE = 35;
    private static final int REQUIRE_PERIOD = 10;
    private static final String REQUIRE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] parts = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]);

        return candidate.getAge() >= REQUIRE_AGE
                && periodInUkr >= REQUIRE_PERIOD
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRE_NATIONALITY);
    }
}
