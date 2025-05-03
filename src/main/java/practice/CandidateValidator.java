package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_UKR = 10;
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        int periodInUkr = Integer.parseInt(years[TO_YEAR_INDEX])
                - Integer.parseInt(years[FROM_YEAR_INDEX]);
        return candidate.getAge() >= REQUIRED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkr >= REQUIRED_PERIOD_IN_UKR;
    }
}
