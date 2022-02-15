package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_YEAR_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_CANDIDATE
            & candidate.getNationality().equals("Ukrainian")
            & candidate.isAllowedToVote()
            & getAllYearsInUkr(candidate.getPeriodsInUkr()) >= MIN_YEAR_IN_UKRAINE;
    }

    private int getAllYearsInUkr(String periodInUkr) {
        String[] firstAndLastYear = periodInUkr.split("-");
        return Integer.parseInt(firstAndLastYear[LAST_YEAR_INDEX])
            - Integer.parseInt(firstAndLastYear[FIRST_YEAR_INDEX]);
    }
}
