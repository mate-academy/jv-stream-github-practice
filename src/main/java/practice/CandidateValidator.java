package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_REQUIRED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitResult = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(splitResult[1]) - Integer.parseInt(splitResult[0]);
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkr >= MIN_REQUIRED_PERIOD;
    }
}
