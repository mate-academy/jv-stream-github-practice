package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UA = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int INDEX_FROM_LAST_YEAR = 0;
    private static final int INDEX_TO_FIRST_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        int yearsLivingInUK = Integer.parseInt(periodInUkraine[INDEX_TO_FIRST_YEAR])
                - Integer.parseInt(periodInUkraine[INDEX_FROM_LAST_YEAR]);
        return yearsLivingInUK >= MIN_YEARS_IN_UA
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE;
    }
}
