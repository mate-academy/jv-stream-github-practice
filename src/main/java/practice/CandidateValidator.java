package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String RESIDENCE_DATE_SPLITTER = "-";
    private static final int POSITION_OF_START_OF_LIVING_PERIOD = 0;
    private static final int POSITION_OF_END_OF_LIVING_RESIDENCE = 1;
    private static final int MIN_PERIOD_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && candidate.isAllowedToVote()
                && isValidPeriodOfResidence(candidate);
    }

    private boolean isValidPeriodOfResidence(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(RESIDENCE_DATE_SPLITTER);
        int startDate = Integer.parseInt(dates[POSITION_OF_START_OF_LIVING_PERIOD]);
        int endDate = Integer.parseInt(dates[POSITION_OF_END_OF_LIVING_RESIDENCE]);
        return endDate - startDate >= MIN_PERIOD_IN_COUNTRY;
    }
}
