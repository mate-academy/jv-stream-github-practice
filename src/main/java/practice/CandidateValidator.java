package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";
    private static final int MIN_COUNT_OF_YEAR_LIVE_IN_UA = 10;
    private static int FROM_YEAR_LIVE_IN_UA = 0;
    private static int TO_YEAR_LIVE_IN_UA = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUk = candidate.getPeriodsInUkr().split(REGEX);
        int durationLivingInUK = Integer.parseInt(periodsInUk[TO_YEAR_LIVE_IN_UA])
                - Integer.parseInt(periodsInUk[FROM_YEAR_LIVE_IN_UA]);
        boolean durationTrue = durationLivingInUK >= MIN_COUNT_OF_YEAR_LIVE_IN_UA;
        return durationTrue
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY);
    }
}
