package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);

        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkr >= 10;
    }
}
