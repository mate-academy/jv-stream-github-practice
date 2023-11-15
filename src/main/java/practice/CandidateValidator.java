package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_OLD = 35;
    private static final int MIN_TOTAL_DURATION = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";
    private static final int SINCE_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= MIN_YEARS_OLD && candidate.isAllowedToVote()
                && VALID_NATIONALITY.equals(candidate.getNationality())) {
            String[] years = candidate.getPeriodsInUkr().split(REGEX);

            int totalDuration = Integer.parseInt(years[TO_YEAR_INDEX])
                    - Integer.parseInt(years[SINCE_YEAR_INDEX]);

            return totalDuration >= MIN_TOTAL_DURATION;
        }
        return false;
    }
}
