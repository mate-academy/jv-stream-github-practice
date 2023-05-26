package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String DASH_SIGN = "-";
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && getYearsOfLiving(candidate) > MIN_YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int getYearsOfLiving(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DASH_SIGN);
        int toYear = Integer.parseInt(years[1]);
        int fromYear = Integer.parseInt(years[0]);
        return toYear - fromYear;
    }
}
