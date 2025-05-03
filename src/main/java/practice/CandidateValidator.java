package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PROPER_NATIONALITY = "Ukrainian";
    private static final String DATA_SEPARATOR = "-";
    private static final int MIN_AGE_VALUE = 35;
    private static final int PERIOD_IN_UKR = 10;
    private static final int INDEX_FROM_ZERO = 0;
    private static final int INDEX_FROM_ONE = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitData = candidate.getPeriodsInUkr().split(DATA_SEPARATOR);
        int periodLivingInUkraine = Integer.parseInt(splitData[INDEX_FROM_ONE])
                - Integer.parseInt(splitData[INDEX_FROM_ZERO]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(PROPER_NATIONALITY)
                && candidate.getAge() >= MIN_AGE_VALUE
                && periodLivingInUkraine >= PERIOD_IN_UKR;
    }
}
