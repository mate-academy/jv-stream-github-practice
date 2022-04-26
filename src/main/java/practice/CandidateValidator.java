package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_COUNTRY = 10;

    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && getYearsLivingInUkraine(candidate) >= YEARS_IN_COUNTRY
                && candidate.isAllowedToVote();
    }

    private int getYearsLivingInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
