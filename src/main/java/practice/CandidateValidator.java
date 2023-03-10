package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DATA_SPLIT = "-";
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int FROM_DATE_INDEX = 0;
    private static final int TILL_DATE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(DATA_SPLIT);
        int fromDateInUkraine = Integer.parseInt(dates[FROM_DATE_INDEX]);
        int tillDateInUkraine = Integer.parseInt(dates[TILL_DATE_INDEX]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && (tillDateInUkraine - fromDateInUkraine) >= 10;
    }
}
