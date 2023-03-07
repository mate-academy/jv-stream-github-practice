package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_FROM = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int FROM_PERIOD_IN_UKR = 10;
    private static final int FIRST_DATE_INDEX = 0;
    private static final int SECOND_DATE_INDEX = 1;
    private static final String DATE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate c) {
        String[] dates = c.getPeriodsInUkr().split(DATE_SEPARATOR);
        int firstDate = Integer.parseInt(dates[FIRST_DATE_INDEX]);
        int secondDate = Integer.parseInt(dates[SECOND_DATE_INDEX]);
        return c.getAge() >= AGE_FROM
                && c.isAllowedToVote()
                && c.getNationality().equals(VALID_NATIONALITY)
                && (secondDate - firstDate) >= FROM_PERIOD_IN_UKR;
    }
}
