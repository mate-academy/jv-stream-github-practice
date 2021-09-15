package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int COLUMN_FROM_YEAR = 0;
    private static final int COLUMN_TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(periods[COLUMN_TO_YEAR])
                - Integer.parseInt(periods[COLUMN_FROM_YEAR])) >= 10;
    }
}
