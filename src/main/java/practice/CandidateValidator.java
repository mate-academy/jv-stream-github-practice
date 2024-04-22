package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String DIVIDER = "-";
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_YEARS_IN_UKRAINE = 10;
    private static final int SIZE_TWO_ELEMENT = 2;
    private static final int PERIOD_FROM = 0;
    private static final int PERIOD_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return hasMinimumAge(candidate)
                && isAllowedToVote(candidate)
                && isUkrainian(candidate)
                && hasLivedInUkraineLongEnough(candidate);
    }

    private boolean hasMinimumAge(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE;
    }

    private boolean isAllowedToVote(Candidate candidate) {
        return candidate.isAllowedToVote();
    }

    private boolean isUkrainian(Candidate candidate) {
        return UKRAINIAN_NATIONALITY.equals(candidate.getNationality());
    }

    private boolean hasLivedInUkraineLongEnough(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(DIVIDER);
        if (periods.length != SIZE_TWO_ELEMENT) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(periods[PERIOD_FROM]);
            int endYear = Integer.parseInt(periods[PERIOD_TO]);
            return (endYear - startYear) >= MINIMUM_YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
