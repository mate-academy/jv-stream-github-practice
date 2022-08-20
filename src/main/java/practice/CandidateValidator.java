package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriodInUkraine(candidate.getPeriodsInUkr()) >= PERIOD_IN_UKRAINE;
    }

    private int getPeriodInUkraine(String periodsInUkr) {
        int yearBeginLiveInUkraine = Integer.parseInt(periodsInUkr.split("-")[0]);
        int yearEndLiveInUkraine = Integer.parseInt(periodsInUkr.split("-")[1]);
        return yearEndLiveInUkraine - yearBeginLiveInUkraine;
    }
}
