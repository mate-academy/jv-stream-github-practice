package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVING_IN_UKRAINE = 10;
    private static final int INDEX_OF_START_LIVING_IN_UKRAINE = 0;
    private static final int INDEX_OF_FINISH_LIVING_IN_UKRAINE = 1;
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(SPLITTER);
        int startLivingInUkraine
                = Integer.parseInt(periodInUkraine[INDEX_OF_START_LIVING_IN_UKRAINE]);
        int finishLivingInUkraine
                = Integer.parseInt((periodInUkraine[INDEX_OF_FINISH_LIVING_IN_UKRAINE]));
        int factPeriodLivingInUkraine = finishLivingInUkraine - startLivingInUkraine;
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && factPeriodLivingInUkraine >= MIN_PERIOD_LIVING_IN_UKRAINE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
