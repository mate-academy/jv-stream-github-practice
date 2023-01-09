package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T extends Candidate> implements Predicate<T> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_COUNTRY = 10;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(T candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsLiveInCountry = Integer.parseInt(years[TO_YEAR_INDEX])
                - Integer.parseInt(years[FROM_YEAR_INDEX]);
        return candidate.isAllowedToVote()
                && (candidate.getAge() >= MIN_AGE)
                && (candidate.getNationality().equals(REQUIRED_NATIONALITY))
                && (yearsLiveInCountry >= MIN_PERIOD_IN_COUNTRY);
    }
}
