package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate <Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVING_IN_UKRAINE = 10;
    private static final int INDEX_OF_START_LIVING_IN_UKRAINE = 0;
    private static final int INDEX_OF_FINISH_LIVING_IN_UKRAINE = 1;
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodLivingInUkraine = candidate.getPeriodsInUkr().split(SPLITTER);
        int startTimeOfLivingInUkraine = Integer.parseInt(periodLivingInUkraine[INDEX_OF_START_LIVING_IN_UKRAINE]);
        int finishTimeOfLivingInUkraine = Integer.parseInt((periodLivingInUkraine[INDEX_OF_FINISH_LIVING_IN_UKRAINE]));
        int factPeriodLivingInUkraine = finishTimeOfLivingInUkraine - startTimeOfLivingInUkraine;
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && factPeriodLivingInUkraine >= MIN_PERIOD_LIVING_IN_UKRAINE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
