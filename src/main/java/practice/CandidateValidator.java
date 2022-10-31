package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String NEEDED_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] neededPeriod = candidate.getPeriodsInUkr().split(NEEDED_REGEX);
        int result = Integer.parseInt(neededPeriod[1]) - Integer.parseInt(neededPeriod[0]);
        return candidate.getAge() >= MIN_AGE
                && result >= MIN_PERIOD_IN_UKR
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
