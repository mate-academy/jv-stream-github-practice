package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    private int getTimeInUkraine(String period) {
        return Arrays.stream(period.split(","))
                .map(String::trim)
                .map(d -> d.split(("-")))
                .mapToInt(e -> Integer.parseInt(e[1].trim()) - Integer.parseInt(e[0].trim()))
                .sum();
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && REQUIRED_NATIONALITY.equalsIgnoreCase(candidate.getNationality())
                && getTimeInUkraine(candidate.getPeriodsInUkr()) >= REQUIRED_YEARS_IN_UKRAINE;
    }
}
