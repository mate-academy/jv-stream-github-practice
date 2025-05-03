package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_DURATION_IN_UKRAINE = 10;
    private static final int FROM_YEAR_TO_LIVE_IN_UKRAINE = 0;
    private static final int TO_YEAR_LIVE_IN_UKRAINE = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int durationLivingInUk = Integer.parseInt(years[TO_YEAR_LIVE_IN_UKRAINE])
                - Integer.parseInt(years[FROM_YEAR_TO_LIVE_IN_UKRAINE]);
        boolean durationTrue = durationLivingInUk >= MIN_DURATION_IN_UKRAINE;
        return durationTrue
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY);
    }
}
