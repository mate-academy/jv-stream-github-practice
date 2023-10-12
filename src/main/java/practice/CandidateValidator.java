package practice;

import static java.lang.Integer.parseInt;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DATE_SEPARATOR = "-";
    private static final String UKRAINE_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_TIME_LIVED_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] datePeriod = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        int periodLivingInCountry = parseInt(datePeriod[1]) - parseInt(datePeriod[0]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINE_NATIONALITY)
                && periodLivingInCountry > MIN_TIME_LIVED_IN_COUNTRY;
    }
}
