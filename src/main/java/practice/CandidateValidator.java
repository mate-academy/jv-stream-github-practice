package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && calculatePeriodInUkraine(candidate) >= 10;
    }

    private int calculatePeriodInUkraine(Candidate candidate) {
        String[] stringDates = candidate.getPeriodsInUkr().split(PERIOD_SPLIT_REGEX);
        return Integer.parseInt(stringDates[1]) - Integer.parseInt(stringDates[0]);
    }
}
