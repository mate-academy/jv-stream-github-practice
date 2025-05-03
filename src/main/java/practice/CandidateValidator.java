package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_YEAR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH_SIGN = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getLivingYear(candidate) > MIN_LIVING_YEAR;
    }

    private int getLivingYear(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DASH_SIGN);
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear;
    }
}
