package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final String NATIONALITY_FOR_CANDIDATE = "Ukrainian";
    private static final int MIN_PERIODS_IN_UKRAINE = 10;
    private static final int INDEX_FOR_TO_DATE = 1;
    private static final int INDEX_FOR_FROM_DATE = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] splittedPeriod = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(String.valueOf(splittedPeriod[INDEX_FOR_TO_DATE]))
                - Integer.parseInt(String.valueOf(splittedPeriod[INDEX_FOR_FROM_DATE]));
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY_FOR_CANDIDATE)
                && candidate.isAllowedToVote()
                && periodInUkraine >= MIN_PERIODS_IN_UKRAINE;
    }
}
