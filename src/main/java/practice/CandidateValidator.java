package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    public static final int MIN_BOUNDARY_AGE = 35;
    public static final String HYPHEN_SEPARATOR = "-";
    public static final int MIN_PERIOD_IN_UKRAINE_INDEX = 0;
    public static final int MAX_PERIOD_IN_UKRAINE_INDEX = 1;
    public static final int MIN_BOUNDARY_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_BOUNDARY_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && getLivePeriodsInUkr(candidate);
    }

    private boolean getLivePeriodsInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(HYPHEN_SEPARATOR);
        int startYear = Integer.parseInt(years[MIN_PERIOD_IN_UKRAINE_INDEX]);
        int endYear = Integer.parseInt(years[MAX_PERIOD_IN_UKRAINE_INDEX]);
        return endYear - startYear >= MIN_BOUNDARY_PERIOD_IN_UKRAINE;
    }
}
