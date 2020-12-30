package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriod(candidate) >= PERIOD;
    }

    private int getPeriod(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}
