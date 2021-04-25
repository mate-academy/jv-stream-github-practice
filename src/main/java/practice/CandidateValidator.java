package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLIT_REGEX = "-";
    private static final int END_PERIOD = 1;
    private static final int START_PERIOD = 0;
    private static final int REQUIRED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkLivingPeriod(candidate.getPeriodsInUkr());
    }

    private boolean checkLivingPeriod(String period) {
        String[] splattedPeriod = period.split(SPLIT_REGEX);
        return Integer.parseInt(splattedPeriod[END_PERIOD]) - Integer
                .parseInt(splattedPeriod[START_PERIOD]) >= REQUIRED_PERIOD;
    }
}
