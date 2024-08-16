package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-";
    private static final int MIN_LIVE_PERIOD_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && liveInCountryEnough(candidate);
    }

    private boolean liveInCountryEnough(Candidate candidate) {
        String[] periodsArray = candidate.getPeriodsInUkr().split(DELIMITER);
        return Integer.parseInt(periodsArray[1])
                - Integer.parseInt(periodsArray[0]) >= MIN_LIVE_PERIOD_IN_COUNTRY;
    }

}
