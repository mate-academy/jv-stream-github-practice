package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_ALLOWED_AGE = 35;
    public static final int MIN_LIVING_YEARS = 10;
    public static final String ALLOWED_NATIONALITY = "Ukrainian";

    static boolean hasSufficientResidency(String periodsInUkr) {
        if (periodsInUkr == null || !periodsInUkr.contains("-")) {
            return false;
        }

        String[] years = periodsInUkr.split("-");
        try {
            int startYear = Integer.parseInt(years[0].trim());
            int endYear = Integer.parseInt(years[1].trim());
            return (endYear - startYear) >= MIN_LIVING_YEARS;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && ALLOWED_NATIONALITY.equals(candidate.getNationality())
                && hasSufficientResidency(candidate.getPeriodsInUkr());
    }
    //write your code here
}
