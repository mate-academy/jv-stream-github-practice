package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T extends Candidate> implements Predicate<T> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEAR_LIVE_IN_COUNTRY = 10;
    private static final int PERIODS_IN_UKR_FROM_INDEX = 0;
    private static final int PERIODS_IN_UKR_TO_INDEX = 1;

    @Override
    public boolean test(T candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsLiveInCountry = Integer.parseInt(years[PERIODS_IN_UKR_TO_INDEX])
                - Integer.parseInt(years[PERIODS_IN_UKR_FROM_INDEX]);
        return candidate.isAllowedToVote()
                && (candidate.getAge() >= MIN_AGE)
                && (candidate.getNationality().equals(NATIONALITY))
                && (yearsLiveInCountry >= MIN_YEAR_LIVE_IN_COUNTRY);
    }
}
