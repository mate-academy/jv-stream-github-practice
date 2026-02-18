package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_NEEDED = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";
    private static final int POS_BEGINNING = 0;
    private static final int POS_END = 1;
    private static final int PERIOD_NEEDED = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        int period = Integer.parseInt(periods[POS_END])
                - Integer.parseInt(periods[POS_BEGINNING]);
        return candidate.isAllowedToVote()
            && candidate.getAge() >= MIN_AGE
            && candidate.getNationality().equals(NATIONALITY_NEEDED)
            && period >= PERIOD_NEEDED;
    }
}
