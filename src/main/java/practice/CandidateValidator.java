package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEAR_IN_UKRAIN = 10;
    private static final String TARGET_NATIONALITY = "Ukrainian";
    private static final String COMA_SPLIT = ",";
    private static final String DASH_SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && TARGET_NATIONALITY.equals(candidate.getNationality())
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEAR_IN_UKRAIN;
    }

    private int calculateYearsInUkraine(String periods) {
        return Arrays.stream(periods.split(COMA_SPLIT))
                .map(String::trim)
                .mapToInt(period -> {
                    String[] years = period.split(DASH_SPLIT);
                    int startYear = Integer.parseInt(years[0]);
                    int endYear = Integer.parseInt(years[1]);
                    return endYear - startYear;
                })
                .sum();
    }
}
