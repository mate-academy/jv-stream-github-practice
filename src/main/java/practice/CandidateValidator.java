package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        final String nationality = "Ukrainian";
        final int ageLimit = 35;
        return candidate.getAge() >= ageLimit
                && candidate.isAllowedToVote()
                && nationality.equals(candidate.getNationality())
                && isEligibleResidency(candidate.getPeriodsInUkr());
    }

    private static boolean isEligibleResidency(String periodInUkr) {
        final int requiredPeriodInUkr = 10;
        if (periodInUkr == null || !periodInUkr.matches("\\d{4}-\\d{4}")) {
            return false;
        }
        String[] years = periodInUkr.split("-");
        int startYear = Integer.parseInt((years[0]));
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear >= requiredPeriodInUkr;
    }
}
