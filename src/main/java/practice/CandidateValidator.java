package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MIN_COUNTRY_LIVE_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && ALLOWED_NATIONALITY.equals(candidate.getNationality())
                && liveInCountryLongEnough(candidate);
    }

    private boolean liveInCountryLongEnough(Candidate candidate) {
        String[] fromToYears = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(fromToYears[1])
                - Integer.parseInt(fromToYears[0]) >= MIN_COUNTRY_LIVE_PERIOD;
    }

}
