package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int START_LIVING_INDEX = 0;
    private static final int FINISH_LIVING_INDEX = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && checkPeriodInUkraine(candidate);
    }

    private boolean checkPeriodInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        int period = Integer.parseInt(years[FINISH_LIVING_INDEX])
                - Integer.parseInt(years[START_LIVING_INDEX]);
        return period >= MIN_PERIOD_IN_UKRAINE;
    }
    //write your code here
}
