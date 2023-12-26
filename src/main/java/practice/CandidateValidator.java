package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_ALLOWED = 10;
    private static final String PERIOD_IN_UKR_SPLITTER = "-";
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(PERIOD_IN_UKR_SPLITTER);
        int fromYear = Integer.parseInt(periodInUkraine[0]);
        int toYear = Integer.parseInt(periodInUkraine[1]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && toYear - fromYear >= MIN_PERIOD_ALLOWED;
    }
}
