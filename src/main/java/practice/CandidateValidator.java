package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] timeInUkr = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(timeInUkr[1]) - Integer.parseInt(timeInUkr[0]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkr >= 10;
    }
}
