package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_AMOUNT_OF_YEARS_IN_COUNTRY = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String DATE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getAmountOfYearsInCountry(candidate) >= REQUIRED_AMOUNT_OF_YEARS_IN_COUNTRY;
    }

    private int getAmountOfYearsInCountry(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
