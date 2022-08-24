package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_START_LIVE_IN_UKRAIN = 0;
    private static final int INDEX_END_LIVE_IN_UKRAIN = 1;
    private static final int MIN_LIVING_PERIOD = 1;
    private static final String DATE_SEPARATOR = "-";

    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        String[] liveFromTo = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        int peroid = Integer.parseInt(liveFromTo[INDEX_END_LIVE_IN_UKRAIN])
                - Integer.parseInt(liveFromTo[INDEX_START_LIVE_IN_UKRAIN]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), NATIONALITY)
                && peroid >= MIN_LIVING_PERIOD;
    }
}
