package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        final int PERIOD_TIME = 10;
        final int MIN_AGE = 35;
        int period;
        String[] date = candidate.getPeriodsInUkr().split("-");
        period = Integer.parseInt(date[1]) - Integer.parseInt(date[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && period > PERIOD_TIME;
    }
}
