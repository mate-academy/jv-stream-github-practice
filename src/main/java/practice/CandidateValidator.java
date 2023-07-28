package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    private static final int MIN_BOUNDARY_AGE = 35;
    private static final String HYPHEN_SEPARATOR = "-";
    private static final int MIN_PERIOD_IN_UKRAINE_INDEX = 0;
    private static final int MAX_PERIOD_IN_UKRAINE_INDEX = 1;
    private static final int MIN_BOUNDARY_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_BOUNDARY_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && isValidLivePeriodsInUkr(candidate);
    }

    private boolean isValidLivePeriodsInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(HYPHEN_SEPARATOR);
        int startYear = Integer.parseInt(years[MIN_PERIOD_IN_UKRAINE_INDEX]);
        int endYear = Integer.parseInt(years[MAX_PERIOD_IN_UKRAINE_INDEX]);
        return endYear - startYear >= MIN_BOUNDARY_PERIOD_IN_UKRAINE;
    }
}
