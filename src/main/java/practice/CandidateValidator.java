package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        System.out.println("Validating candidate: " + candidate.getName());
        boolean valid = candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && isEligibleResidency(candidate.getPeriodsInUkr());
        if (valid) {
            System.out.println("Candidate passed: " + candidate.getName());
        } else {
            System.out.println("Candidate failed: " + candidate.getName());
        }
        return valid;
    }

    private static boolean isEligibleResidency(String periodInUkr) {

        if (periodInUkr == null || !periodInUkr.matches("\\d{4}-\\d{4}")) {
            return false;
        }
        String[] years = periodInUkr.split("-");
        int startYear = Integer.parseInt((years[0]));
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear >= 10;
    }

}
