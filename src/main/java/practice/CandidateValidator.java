package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    private static final String SPLIT_REGEX_HYPHEN = "-";
    private static final int STAR_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final String NEEDED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(NEEDED_NATIONALITY)) {
            String[] inUkrYears = candidate.getPeriodsInUkr().split(SPLIT_REGEX_HYPHEN);
            int startYear = Integer.parseInt(
                    inUkrYears[STAR_YEAR_INDEX]);
            int endYear = Integer.parseInt(
                    inUkrYears[END_YEAR_INDEX]);
            return endYear - startYear >= MIN_PERIOD_IN_UKRAINE;
        }
        return false;
    }
}
