package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final int INDEX_START_YEAR = 0;
    private static final int INDEX_END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String nationality = "Ukrainian";
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(years[INDEX_END_YEAR])
                - Integer.parseInt(years[INDEX_START_YEAR]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(nationality)
                && yearsInUkr >= MIN_YEARS_IN_UKR;
    }
}
