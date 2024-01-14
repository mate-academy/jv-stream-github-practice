package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE_MIN = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_YEARS_MIN = 10;
    private static final String YEARS_REGEX_SPLIT = "-";
    private static final int YEARS_INDEX_START = 0;
    private static final int YEARS_INDEX_END = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEARS_REGEX_SPLIT);
        int yearsCount = Integer.parseInt(years[YEARS_INDEX_END])
                - Integer.parseInt(years[YEARS_INDEX_START]);
        if (candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE_MIN
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && yearsCount >= VALID_YEARS_MIN) {
            return true;
        } else {
            return false;
        }
    }
}
