package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String COMMA = ",";
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35 || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(UKRAINIAN_NATIONALITY)) {
            return false;
        }

        int yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split(COMMA))
                .mapToInt(period -> parsePeriod(period))
                .sum();

        return yearsInUkraine >= 10;
    }

    private int parsePeriod(String period) {
        String[] parts = period.split(DASH);
        return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]);
    }
}
