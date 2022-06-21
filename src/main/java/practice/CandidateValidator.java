package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_LIVE_IN_UKR = 10;
    private static final int YEAR_INDEX_ONE = 0;
    private static final int YEAR_INDEX_TWO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] arrayYears = candidate.getPeriodsInUkr().split("-");
        return (candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(arrayYears[YEAR_INDEX_TWO])
                - Integer.parseInt(arrayYears[YEAR_INDEX_ONE])) >= MIN_LIVE_IN_UKR)
                && candidate.isAllowedToVote();
    }
}

