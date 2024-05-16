package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && hasSufficientResidencyInUkr(candidate);
    }

    private boolean hasSufficientResidencyInUkr(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR);
        if (periods.length == 2) {
            try {
                int startYear = Integer.parseInt(periods[BEGIN_INDEX]);
                int endYear = Integer.parseInt(periods[END_INDEX]);
                return (endYear - startYear) >= MIN_YEARS_IN_UKRAINE;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
