package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<C extends Candidate> implements Predicate<C> {
    private static final String DATE_SEPARATOR = "-";
    private static final String UKRAINE_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_TIME_LIVED_IN_COUNTRY = 10;
    private static boolean allowedToVote = true;

    @Override
    public boolean test(C candidate) {
        String[] datePeriod = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        int livedInCountryFor = Integer.parseInt(datePeriod[1]) - Integer.parseInt(datePeriod[0]);
        allowedToVote = candidate.isAllowedToVote();

        return candidate.getAge() >= MIN_AGE
                && allowedToVote
                && candidate.getNationality().equals(UKRAINE_NATIONALITY)
                && livedInCountryFor > MIN_TIME_LIVED_IN_COUNTRY;
    }
}
