package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int COMING_TO_UKRAIN = 0;
    private static final int EXIT_FROM_UKRAINE = 1;
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_LIVE_IN_UKRAIN = 10;
    private static final String UKRAINIAN = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(UKRAINIAN)
                && Integer.parseInt(period[EXIT_FROM_UKRAINE])
                - Integer.parseInt(period[COMING_TO_UKRAIN]) > MINIMUM_LIVE_IN_UKRAIN
                && candidate.isAllowedToVote();
    }
}
