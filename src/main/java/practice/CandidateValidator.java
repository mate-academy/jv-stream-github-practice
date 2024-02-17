package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final String NATIONALITY_TO_VOTE = "Ukrainian";
    private static final int MIN_YEARS_TO_LIVE_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] fromToInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY_TO_VOTE)
                && checkYearsInCountry(fromToInUkraine)
                && candidate.isAllowedToVote();
    }

    private boolean checkYearsInCountry(String[] fromToInUkraine) {
        return Integer.parseInt(fromToInUkraine[ONE]) - Integer.parseInt(fromToInUkraine[ZERO])
                >= MIN_YEARS_TO_LIVE_IN_COUNTRY;
    }
}
