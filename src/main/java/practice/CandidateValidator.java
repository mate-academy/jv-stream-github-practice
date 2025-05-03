package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    public static final int PERIOD_IN_UKR = 10;
    public static final int BEGIN_INDEX = 0;
    public static final int END_INDEX = 1;
    private static final String DELIMITER_HYPHEN = "-";
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(DELIMITER_HYPHEN);
        return Integer.parseInt(dates[END_INDEX])
                - Integer.parseInt(dates[BEGIN_INDEX]) >= PERIOD_IN_UKR;
    }
}
