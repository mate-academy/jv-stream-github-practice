package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_FROM = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int FROM_PERIOD_IN_UKR = 10;
    private static final int STARTING_DATE_INDEX = 0;
    private static final int CURRENT_DATE_INDEX = 1;
    private static final String DATE_FORMAT_DASH_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(DATE_FORMAT_DASH_SEPARATOR);
        int startingDate = Integer.parseInt(dates[STARTING_DATE_INDEX]);
        int currentDate = Integer.parseInt(dates[CURRENT_DATE_INDEX]);
        return candidate.getAge() >= AGE_FROM
            && candidate.isAllowedToVote()
            && candidate.getNationality().equals(VALID_NATIONALITY)
            && (currentDate - startingDate) >= FROM_PERIOD_IN_UKR;
    }
}
