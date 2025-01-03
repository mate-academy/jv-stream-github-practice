package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equalsIgnoreCase(candidate.getNationality())
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split(","))
                .map(period -> period.split("-"))
                .mapToInt(years -> Integer.parseInt(years[1]) - Integer.parseInt(years[0]))
                .sum() >= REQUIRED_YEARS;
    }
}
