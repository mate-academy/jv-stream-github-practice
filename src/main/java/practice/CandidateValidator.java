package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final int FIRST_YEAR = 0;
    private static final int LAST_YEAR = 1;
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && YEARS_IN_UKRAINE <= (Integer.parseInt(years[LAST_YEAR])
                - Integer.parseInt(years[FIRST_YEAR]));
    }
}
