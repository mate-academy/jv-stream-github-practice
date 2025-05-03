package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final int FROM_YEARS_INDEX = 0;
    private static final int TO_YEARS_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        int yearsInUkraine = Integer.parseInt(years[TO_YEARS_INDEX])
                - Integer.parseInt(years[FROM_YEARS_INDEX]);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsInUkraine >= MIN_YEARS_IN_UKR
                && candidate.getAge() >= MIN_CANDIDATE_AGE;
    }
}
