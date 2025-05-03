package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_LIVING_IN_UKRAINE = 10;
    private static final String REQUARED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUARED_NATIONALITY)
                && getYearsLivingInUkraine(candidate) >= MIN_YEARS_LIVING_IN_UKRAINE;
    }

    private int getYearsLivingInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
