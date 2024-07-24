package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String SPLITTER = "-";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(SPLITTER);
        return Integer.parseInt(dates[SECOND_INDEX])
                - Integer.parseInt(dates[FIRST_INDEX]) >= YEARS_IN_UKRAINE;
    }
}
