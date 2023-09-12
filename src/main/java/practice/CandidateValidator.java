package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int PERIOD_IN_UKR = 10;
    private static final String SEPARATOR = "-";
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(dates[END_INDEX]) - Integer.parseInt(dates[BEGIN_INDEX]) >= PERIOD_IN_UKR;
    }
}
