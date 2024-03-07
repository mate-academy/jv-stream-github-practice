package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DASH = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String ALLOWABLE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return isOldEnough(candidate)
                && candidate.isAllowedToVote()
                && isUkrainian(candidate)
                && isLivedInUkraineEnough(candidate);
    }

    private boolean isOldEnough(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE;
    }

    private boolean isUkrainian(Candidate candidate) {
        return candidate.getNationality().equals(ALLOWABLE_NATIONALITY);
    }

    private boolean isLivedInUkraineEnough(Candidate candidate) {
        String[] arr = candidate.getPeriodsInUkr().split(DASH);
        int period = Integer.parseInt(arr[END_YEAR_INDEX])
                - Integer.parseInt(arr[START_YEAR_INDEX]);
        return period >= MIN_PERIOD_IN_UKRAINE;
    }
}
