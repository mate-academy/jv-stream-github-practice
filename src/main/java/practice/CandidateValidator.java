package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_COUNTRY = 10;
    private static final int START_LIVING_YEAR_INDEX = 0;
    private static final int END_LIVING_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsInCountry = Integer.parseInt(years[END_LIVING_YEAR_INDEX])
                - Integer.parseInt(years[START_LIVING_YEAR_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInCountry >= MIN_YEARS_IN_COUNTRY;
    }
}
