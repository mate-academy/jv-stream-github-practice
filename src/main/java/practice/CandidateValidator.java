package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_AGE = 35;
    private static final int NEEDED_YEARS_TO_LIVE = 10;
    private static final int CURRENT_YEAR = 2021;
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int SECOND_YEAR_INDEX = 1;
    private static final int EMPTY_STRING_SIZE = 0;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final String YEAR_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && hasLivedLongEnough(candidate);
    }

    private boolean hasLivedLongEnough(Candidate candidate) {
        String[] livingPeriod = candidate.getPeriodsInUkr().split(YEAR_REGEX);
        int firstYear = Integer.parseInt(livingPeriod[FIRST_YEAR_INDEX]);
        int lastYear = livingPeriod[SECOND_YEAR_INDEX].length() > EMPTY_STRING_SIZE
                ? Integer.parseInt(livingPeriod[SECOND_YEAR_INDEX]) : CURRENT_YEAR;
        return lastYear - firstYear >= NEEDED_YEARS_TO_LIVE;
    }
}
