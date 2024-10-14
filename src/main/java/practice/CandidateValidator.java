package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String LINE_SEPARATOR = "-";
    private static final String CORRECT_NATIONALITY = "Ukrainian";
    private static final int ENOUGH_YEARS = 10;
    private static final int MINIMAL_AGE = 35;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return isAgeValid(candidate)
                && isNationalityValid(candidate)
                && candidate.isAllowedToVote()
                && isEnoughYearsInUkraine(candidate);
    }

    private boolean isAgeValid(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_AGE;
    }

    private boolean isNationalityValid(Candidate candidate) {
        return candidate.getNationality().equals(CORRECT_NATIONALITY);
    }

    private boolean isEnoughYearsInUkraine(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] years = periodsInUkr.split(LINE_SEPARATOR);
        int startYear = Integer.parseInt(years[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(years[END_YEAR_INDEX]);
        int yearsInUkraine = endYear - startYear;
        return yearsInUkraine >= ENOUGH_YEARS;
    }
}
