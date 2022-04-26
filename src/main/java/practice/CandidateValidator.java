package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int INDEX_OF_FIRST_YEAR = 0;
    private static final int INDEX_OF_LAST_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(years[INDEX_OF_FIRST_YEAR]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= MIN_YEARS_IN_UKRAINE;
    }
}
