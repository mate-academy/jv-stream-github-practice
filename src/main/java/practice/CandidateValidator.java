package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int livingPeriod = Integer.parseInt(candidate.getPeriodsInUkr().substring(5))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4));

        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && livingPeriod >= MIN_LIVING_PERIOD;
    }
}

