package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int AGE_MIN_VALID = 35;
    private static final String NATIONALITY_VALID = "Ukrainian";
    private static final int YEARS_MIN_VALID = 10;
    private static final String YEARS_REGEX_SPLIT = "-";
    private static final int YEARS_INDEX_START = 0;
    private static final int YEARS_INDEX_END = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEARS_REGEX_SPLIT);
        int yearsCount = Integer.parseInt(years[YEARS_INDEX_END])
                - Integer.parseInt(years[YEARS_INDEX_START]);
        if (candidate.isAllowedToVote()
                && candidate.getAge() >= AGE_MIN_VALID
                && candidate.getNationality().equals(NATIONALITY_VALID)
                && yearsCount >= YEARS_MIN_VALID) {
            return true;
        }
        return false;
    }
}
