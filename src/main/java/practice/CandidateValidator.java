package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String YEARS_PARSE_SPLIT = "-";
    private static final int MINIMAL_AGE = 35;
    private static final int YEARS_IN_COUNTRY = 10;
    private static final int YEARS_FROM_INDEX = 0;
    private static final int YEARS_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && hasLivedForYears(candidate);
    }

    private boolean hasLivedForYears(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split(YEARS_PARSE_SPLIT);
        int from = Integer.parseInt(split[YEARS_FROM_INDEX]);
        int to = Integer.parseInt(split[YEARS_TO_INDEX]);
        return to - from >= YEARS_IN_COUNTRY;
    }
}
