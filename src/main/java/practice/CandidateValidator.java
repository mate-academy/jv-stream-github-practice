package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_PRESIDENT = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int INDEX_FROM_YEAR = 0;
    private static final int INDEX_TO_YEAR = 1;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        boolean isLiveInUkraineForTenYears = Integer.parseInt(years[INDEX_TO_YEAR])
                - Integer.parseInt(years[INDEX_FROM_YEAR]) >= MIN_YEARS_IN_UKRAINE;
        return candidate.getAge() >= MIN_AGE_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && isLiveInUkraineForTenYears;
    }
}
