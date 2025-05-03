package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD = 10;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String [] strings = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(strings[1])
                - Integer.parseInt(strings[0]);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && period >= MIN_PERIOD;
    }
}

