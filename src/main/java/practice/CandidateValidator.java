package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PERIOD_SEPARATOR = "-";
    private static final String UKRAINIAN = "Ukrainian";
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;
    private static final int END_PERIOD_INDEX = 1;
    private static final int START_PERIOD_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIOD_SEPARATOR)[END_PERIOD_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIOD_SEPARATOR)[START_PERIOD_INDEX])
                >= MINIMUM_PERIOD_IN_UKRAINE;
    }
}
