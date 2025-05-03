package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEARS_FROM_INDEX = 0;
    private static final int YEARS_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getPeriodInUkraine(candidate.getPeriodsInUkr()) >= REQUIRED_PERIOD_IN_UKRAINE;
    }

    private int getPeriodInUkraine(String periodsInUkr) {
        String[] splitted = periodsInUkr.split("-");
        int yearBeginLiveInUkraine = Integer.parseInt(splitted[YEARS_FROM_INDEX]);
        int yearEndLiveInUkraine = Integer.parseInt(splitted[YEARS_TO_INDEX]);
        return yearEndLiveInUkraine - yearBeginLiveInUkraine;
    }
}
