package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] fromToPeriodInUkr = candidate.getPeriodsInUkr().split("-");
        int timeLiveInUkr =
                Integer.parseInt(fromToPeriodInUkr[1]) - Integer.parseInt(fromToPeriodInUkr[0]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && timeLiveInUkr >= 10;
    }
}
