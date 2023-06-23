package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINE_NATIONALITY = "Ukrainian";
    public static final int INDEX_FROM_YEAR = 0;
    public static final int INDEX_TO_YEAR = 1;
    public static final int PERIOD_TO_VOTE = 10;

    @Override
    public boolean test(Candidate candidate) {

        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINE_NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_TO_YEAR])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_FROM_YEAR])
                >= PERIOD_TO_VOTE);
    }
}
