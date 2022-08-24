package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int IN_UKRAINE_FROM = 0;
    private static final int IN_UKRAINE_TILL = 1;
    private static final int MIN_PERIOD = 10;
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final String DASH_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(NATIONALITY_UKR)) {
            return false;
        }
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(DASH_REGEX);
        return Integer.parseInt(periodInUkraine[IN_UKRAINE_TILL])
                - Integer.parseInt(periodInUkraine[IN_UKRAINE_FROM]) >= MIN_PERIOD;
    }
}
