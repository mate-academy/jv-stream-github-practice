package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_INDEX_START = 0;
    private static final int LAST_INDEX_END = 1;
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY_FOR_CANDIDATE = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getClass().equals(Candidate.class)
                && candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_FOR_CANDIDATE)
                && getLivePeriodInUkraine(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKRAINE;
    }

    public static int getLivePeriodInUkraine(String periodsInUkr) {
        String[] split = periodsInUkr.split("-");
        return Integer.parseInt(split[LAST_INDEX_END])
                - Integer.parseInt(split[FIRST_INDEX_START]);
    }
}
