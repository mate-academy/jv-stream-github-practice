package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_LIVE_IN_COUNTRY = 10;
    private static final int INDEX_FOR_FIRST_YEAR_IN_COUNTRY = 0;
    private static final int INDEX_FOR_LAST_YEAT_IN_COUNTRY = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= FROM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && verifyTimeLiveInCountry(candidate.getPeriodsInUkr());
    }

    private boolean verifyTimeLiveInCountry(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        int fromYear = Integer.parseInt(years[INDEX_FOR_FIRST_YEAR_IN_COUNTRY]);
        int toYear = Integer.parseInt(years[INDEX_FOR_LAST_YEAT_IN_COUNTRY]);
        return toYear - fromYear >= MIN_LIVE_IN_COUNTRY;

    }
}
