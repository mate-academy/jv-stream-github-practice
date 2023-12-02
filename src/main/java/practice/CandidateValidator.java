package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split(REGEX);
        int firstYear = Integer.parseInt(years[FIRST_YEAR_INDEX]);
        int lastYear = Integer.parseInt(years[LAST_YEAR_INDEX]);
        return candidate.getAge() >= REQUIRED_AGE
                && lastYear - firstYear >= REQUIRED_PERIOD
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY);
    }
}
