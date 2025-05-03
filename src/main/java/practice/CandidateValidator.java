package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_START_INDEX = 0;
    private static final int PERIOD_END_INDEX = 1;
    private static final String PERIOD_SEPARATOR = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_LIVING = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraineBounds = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        int liveFrom = Integer.parseInt(periodInUkraineBounds[PERIOD_START_INDEX]);
        int liveTo = Integer.parseInt(periodInUkraineBounds[PERIOD_END_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && UKRAINIAN_NATIONALITY.equals(candidate.getNationality())
                && liveTo - liveFrom >= MIN_YEARS_LIVING;
    }
    //write your code here
}
