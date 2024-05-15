package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return isOlderThan(candidate, MIN_AGE)
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && hasSufficientResidencyInUkr(candidate);
    }

    private boolean isOlderThan(Candidate candidate, int age) {
        return candidate.getAge() >= age;
    }

    private boolean hasSufficientResidencyInUkr(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        if (periods.length == 2) {
            try {
                int startYear = Integer.parseInt(periods[0]);
                int endYear = Integer.parseInt(periods[1]);
                return (endYear - startYear + 1) >= CandidateValidator.MIN_YEARS_IN_UKRAINE;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
