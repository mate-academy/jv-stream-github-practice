package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String COMMA = ",";
    private static final String DASH = "-";
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD_LIVING_IN_UKRAINE = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= REQUIRED_AGE)
                && (candidate.isAllowedToVote())
                && (REQUIRED_NATIONALITY.equals(candidate.getNationality()))
                && hasLivedInUkraineForAtLeast10Years(candidate);
    }

    private boolean hasLivedInUkraineForAtLeast10Years(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split(COMMA))
                .mapToInt(period -> {
                    String[] years = period.split(DASH);
                    int start = Integer.parseInt(years[START_YEAR_INDEX]);
                    int end = Integer.parseInt(years[END_YEAR_INDEX]);
                    return end - start + 1;
                })
                .sum() >= REQUIRED_PERIOD_LIVING_IN_UKRAINE;
    }
}
