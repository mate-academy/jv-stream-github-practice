package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String EXPECTED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE
            && candidate.getNationality().equals(EXPECTED_NATIONALITY)
            && Integer.parseInt(split[1]) - Integer.parseInt(split[0]) >= MIN_PERIOD
                && candidate.isAllowedToVote();
    }
}
