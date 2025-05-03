package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_CANDIDATE_AGE = 35;
    private static final int MIN_YEARS_LIVED_IN_UKR = 10;
    private static final int FROM_YEARS_INDEX = 0;
    private static final int TO_YEARS_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_BY_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsLivedInUkraine = candidate.getPeriodsInUkr().split(SPLIT_BY_SYMBOL);
        int yearsInUkraine = Integer.parseInt(yearsLivedInUkraine[TO_YEARS_INDEX])
                - Integer.parseInt(yearsLivedInUkraine[FROM_YEARS_INDEX]);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsInUkraine >= MIN_YEARS_LIVED_IN_UKR
                && candidate.getAge() >= MIN_ALLOWED_CANDIDATE_AGE;
    }
}
