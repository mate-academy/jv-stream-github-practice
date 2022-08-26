package practice;

import java.util.function.Predicate;

import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_MIN_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLITERATOR = "-";
    private static final byte PERIOD_TO_INDEX = 1;
    private static final byte PERIOD_FROM_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int period = Integer.parseInt(splitted[PERIOD_TO_INDEX])
                - Integer.parseInt(splitted[PERIOD_FROM_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && period >= REQUIRED_YEARS_IN_UKRAINE;
    }
}
