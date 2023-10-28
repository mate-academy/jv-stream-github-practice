package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String CITIZENSHIP = "Ukrainian";
    private static final int MIN_CITIZENSHIP_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CITIZENSHIP)
                && calculatePeriod(candidate.getPeriodsInUkr()) >= MIN_CITIZENSHIP_PERIOD;
    }

    private static int calculatePeriod(String period) {
        int separatorIndex = period.indexOf('-');
        int begin = Integer.parseInt(period.substring(0, separatorIndex));
        int end = Integer.parseInt(period.substring(separatorIndex + 1));
        return end - begin;
    }
}
