package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final int MIN_LIVED_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FIRST_YEAR = 0;
    private static final int LAST_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && livedYearsInUkraine(candidate) >= MIN_LIVED_IN_UKRAINE;
    }

    private int livedYearsInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[LAST_YEAR])
                - Integer.parseInt(years[FIRST_YEAR]);
    }
}
