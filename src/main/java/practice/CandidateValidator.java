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

    public boolean test(Candidate candidate) {
        int[] yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startYear = yearsInUkraine[START_YEAR_INDEX];
        int endYear = yearsInUkraine[END_YEAR_INDEX];
        int years = endYear - startYear;
        return candidate.getAge() >= MAX_AGE
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && years >= MIN_YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
