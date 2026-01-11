package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (candidate.getAge() < MIN_AGE
                || !candidate.getNationality().equals(NATIONALITY)
                || !candidate.isAllowedToVote()) {
            return false;
        }
        String periodsInUkr = candidate.getPeriodsInUkr();
        if (periodsInUkr != null && !periodsInUkr.isEmpty()) {
            List<String> partsOfPeriod = Arrays.stream(periodsInUkr.trim().split("-"))
                    .collect(Collectors.toList());
            if (partsOfPeriod.size() != 2) {
                return false;
            }
            int startOfPeriod = Integer.parseInt(partsOfPeriod.get(0));
            int endOfPeriod = Integer.parseInt(partsOfPeriod.get(1));
            int totalYears = endOfPeriod - startOfPeriod;
            return totalYears >= MIN_PERIOD_IN_UKRAINE;
        }
        return false;
    }
}
