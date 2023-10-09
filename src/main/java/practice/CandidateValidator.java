package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALUE_OF_YEARS_LIVING_IN_UKRAINE = 10;
    private static final int MIN_VALUE_OF_YEARS_FOR_CANDIDATE_AGE = 35;

    public boolean test(Candidate candidate) {
        int age = candidate.getAge();
        boolean allowedToVote = candidate.isAllowedToVote();
        String nationality = candidate.getNationality();
        String periodsInUkr = candidate.getPeriodsInUkr();
        return age >= MIN_VALUE_OF_YEARS_FOR_CANDIDATE_AGE
                && allowedToVote && "Ukrainian".equals(nationality)
                && isLivedInUkraineForRequiredNumbersOfYears(periodsInUkr);
    }

    private boolean isLivedInUkraineForRequiredNumbersOfYears(String periodsInUkr) {
        String[] yearsInUkraine = periodsInUkr.split("-");
        return (Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0]))
                >= MIN_VALUE_OF_YEARS_LIVING_IN_UKRAINE;
    }
}

