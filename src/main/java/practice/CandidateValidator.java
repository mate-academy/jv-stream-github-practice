package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    public int getMaxAge() {
        return MAX_AGE;
    }

    public int getMinYearsInUkraine() {
        return MIN_YEARS_IN_UKRAINE;
    }

    public String getUkrainianNationality() {
        return UKRAINIAN_NATIONALITY;
    }

    public int getStartYearIndex() {
        return START_YEAR_INDEX;
    }

    public int getEndYearIndex() {
        return END_YEAR_INDEX;
    }

    public boolean test(Candidate candidate) {
        int[] yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startYear = yearsInUkraine[getStartYearIndex()];
        int endYear = yearsInUkraine[getEndYearIndex()];
        int years = endYear - startYear;
        return candidate.getAge() >= getMaxAge()
                && candidate.getNationality().equals(getUkrainianNationality())
                && years >= getMinYearsInUkraine()
                && candidate.isAllowedToVote();
    }
}
