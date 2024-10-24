package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final int SPLIT_LENGTH = 2;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return isEligibleAge(candidate.getAge())
                && candidate.isAllowedToVote()
                && hasRequiredNationality(candidate.getNationality())
                && hasLivedInUkraineLongEnough(candidate.getPeriodsInUkr());
    }

    private boolean isEligibleAge(int age) {
        return age >= MIN_AGE;
    }

    private boolean hasRequiredNationality(String nationality) {
        return REQUIRED_NATIONALITY.equalsIgnoreCase(nationality);
    }

    private boolean hasLivedInUkraineLongEnough(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");
        if (periods.length != SPLIT_LENGTH) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(periods[START_YEAR_INDEX].trim());
            int endYear = Integer.parseInt(periods[END_YEAR_INDEX].trim());
            return (endYear - startYear) >= YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
