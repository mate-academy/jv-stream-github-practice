package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int YEARS_TO_LIVE_REQUIREMENT = 10;
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final String UKRAINE_NATIONALITY = "Ukrainian";
    private static final String HYPHEN_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINE_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        if (candidate.getPeriodsInUkr() != null
                && candidate.getPeriodsInUkr().contains(HYPHEN_SEPARATOR)) {
            String[] dates = candidate.getPeriodsInUkr().split(HYPHEN_SEPARATOR);
            return Integer.parseInt(dates[TO_YEAR_INDEX])
                    - Integer.parseInt(dates[FROM_YEAR_INDEX]) >= YEARS_TO_LIVE_REQUIREMENT;
        }
        return false;
    }
}
