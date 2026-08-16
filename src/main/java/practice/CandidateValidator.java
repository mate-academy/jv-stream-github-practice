package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodsInUkr) {
        String[] yearsInUkraine = periodsInUkr.split("-");
        int yearFrom = Integer.parseInt(yearsInUkraine[0]);
        int yearTo = Integer.parseInt(yearsInUkraine[1]);

        return yearTo - yearFrom >= MIN_YEARS_IN_UKRAINE;
    }
    //write your code here
}
