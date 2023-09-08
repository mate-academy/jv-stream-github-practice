package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    final int maxAge = 35;
    final int minYearsInUkraine = 10;
    final String ukrainianNationality = "Ukrainian";
    final int startYearIndex = 0;
    final int endYearIndex = 1;

    public boolean test(Candidate candidate) {
        int[] yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startYear = yearsInUkraine[startYearIndex];
        int endYear = yearsInUkraine[endYearIndex];
        int years = endYear - startYear;
        return candidate.getAge() >= maxAge
                && candidate.getNationality().equals(ukrainianNationality)
                && years >= minYearsInUkraine
                && candidate.isAllowedToVote();
    }
}
