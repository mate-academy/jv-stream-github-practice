package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINE_NATIONALITY = "Ukrainian";
    public static final int INDEX_FROM_YEAR = 0;
    public static final int INDEX_TO_YEAR = 1;
    public static final int MIN_PERIOD_TO_VOTE = 10;
    public static final int START_AGE_TO_VOTE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] splittedPeriodsInUkr = candidate.getPeriodsInUkr().split("-");

        return candidate.getAge() >= START_AGE_TO_VOTE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINE_NATIONALITY)
                && (Integer.parseInt(splittedPeriodsInUkr[INDEX_TO_YEAR])
                - Integer.parseInt(splittedPeriodsInUkr[INDEX_FROM_YEAR])
                >= MIN_PERIOD_TO_VOTE);
    }
}
