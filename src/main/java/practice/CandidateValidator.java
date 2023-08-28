package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int INDEX_OF_LAST_YEAR_IN_UKRAINE = 1;
    public static final int INDEX_OF_FIRST_YEAR_IN_UKRAINE = 0;
    public static final int MINIMUM_ALLOWED_AGE = 35;
    public static final String DASH = "-";
    public static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), REQUIRED_NATIONALITY)
                && hasLivedRequiredYearsInUkraine(candidate);
    }

    private boolean hasLivedRequiredYearsInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DASH);
        return Integer.parseInt(years[INDEX_OF_LAST_YEAR_IN_UKRAINE])
                - Integer.parseInt(years[INDEX_OF_FIRST_YEAR_IN_UKRAINE]) >= 10;
    }
    //write your code here
}
