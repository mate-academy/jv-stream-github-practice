package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_UKR_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);

        boolean isMinimumAge = candidate.getAge() >= MINIMUM_AGE;
        boolean isAllowedToVote = candidate.isAllowedToVote();
        boolean isUkrainian = candidate.getNationality().equals(UKRAINIAN_NATIONALITY);
        boolean hasMinimumUkrPeriod = endYear - startYear >= MINIMUM_UKR_PERIOD;

        return isMinimumAge && isAllowedToVote && isUkrainian && hasMinimumUkrPeriod;
    }
}
