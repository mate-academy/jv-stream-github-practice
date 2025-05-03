package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int MIN_AGE_FOR_VOTE = 35;
    public static final String MANDATORY_NATIONALITY = "Ukrainian";
    public static final int MIN_PERIOD_IN_UKR = 10;
    public static final String DELEMITER = "-";
    public static final int START_PERIOD_INDEX = 0;
    public static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_VOTE
                && candidate.getNationality().equals(MANDATORY_NATIONALITY)
                && candidate.isAllowedToVote()
                && calculationPeriodLifeInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;
    }

    private static int calculationPeriodLifeInUkr(String period) {
        String[] split = period.split(DELEMITER);
        int startPeriod = Integer.parseInt(split[START_PERIOD_INDEX]);
        int endPeriod = Integer.parseInt(split[END_PERIOD_INDEX]);
        return endPeriod - startPeriod;

    }
}
