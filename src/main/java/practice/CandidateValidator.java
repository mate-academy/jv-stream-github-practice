package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int FROM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_ON_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= FROM_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(periodInUkr[1])
                - Integer.parseInt(periodInUkr[0]) >= PERIOD_ON_UKRAINE;
    }
}
