package practice;

import static java.lang.Integer.parseInt;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_LIVE_IN_UKR = 10;
    private static final int INDEX_YEAR_OF_ENTRY = 0;
    private static final int INDEX_LAST_YEAR_IN_UKR = 1;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality()
                .equals("Ukrainian")
                && isLiveInUkrMoreThanMinPeriod(candidate.getPeriodsInUkr());
    }

    private boolean isLiveInUkrMoreThanMinPeriod(String string) {
        String[] years = string.split("-");
        int yearOfEntry = parseInt(years[INDEX_YEAR_OF_ENTRY]);
        int lastYearInUkr = parseInt(years[INDEX_LAST_YEAR_IN_UKR]);
        return (lastYearInUkr - yearOfEntry) >= MIN_PERIOD_LIVE_IN_UKR;
    }
}
