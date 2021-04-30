package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final int ALLOWED_AGE = 35;
    private static final int ALLOWED_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_OF_LAST_YEAR = 1;
    private static final int INDEX_OF_FIRST_YEAR = 0;
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        int periodInUkraine = Integer.parseInt(yearsInUkraine[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(yearsInUkraine[INDEX_OF_FIRST_YEAR]);
        return candidate.getAge() >= ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && periodInUkraine >= ALLOWED_PERIOD_IN_UKRAINE;

    }
}
