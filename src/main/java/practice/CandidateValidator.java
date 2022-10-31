package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PROPER_NATIONALITY = "Ukrainian";
    private static final String DATA_SEPARATOR = "-";
    private static final int MIN_AGE_VALUE = 35;
    private static final int PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitData = candidate.getPeriodsInUkr().split(DATA_SEPARATOR);
        int periodLivingInUkraine = Integer.parseInt(splitData[1])
                - Integer.parseInt(splitData[0]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(PROPER_NATIONALITY)
                && candidate.getAge() >= MIN_AGE_VALUE
                && periodLivingInUkraine >= PERIOD_IN_UKR;
    }
}
