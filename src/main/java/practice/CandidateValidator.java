package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS = 10;
    private static final int INDEX_OF_FIRST_YEAR = 0;
    private static final int INDEX_OF_LAST_YEAR = 1;
    private static final String REQUIRED_CITIZENSHIP = "Ukrainian";
    private static final String PERIODS_DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(PERIODS_DELIMITER);
        int yearsInUkraine = Integer.parseInt(years[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(years[INDEX_OF_FIRST_YEAR]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_CITIZENSHIP)
                && yearsInUkraine >= REQUIRED_YEARS;
    }
}
