package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int minAge = 35;
    private static final int minYearsInUkraine = 10;
    private static final String targetNationality = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= minAge
                && candidate.isAllowedToVote()
                && targetNationality.equals(candidate.getNationality())
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= minYearsInUkraine;
    }

    private int calculateYearsInUkraine(String periods) {
        return Arrays.stream(periods.split(","))
                .map(String::trim)
                .mapToInt(period -> {
                    String[] years = period.split("-");
                    int startYear = Integer.parseInt(years[0]);
                    int endYear = Integer.parseInt(years[1]);
                    return endYear - startYear;
                })
                .sum();
    }
}
