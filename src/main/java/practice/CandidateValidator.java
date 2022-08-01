package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] timeInUkr = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(timeInUkr[1]) - Integer.parseInt(timeInUkr[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodInUkr >= MIN_PERIOD;
    }
}
