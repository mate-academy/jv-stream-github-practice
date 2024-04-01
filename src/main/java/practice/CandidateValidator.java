package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        int periodInUkrFrom = Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4));
        int periodInUkrTo = Integer.parseInt(candidate.getPeriodsInUkr().substring(5));
        int periodInUkr = periodInUkrTo - periodInUkrFrom;
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkr >= 10;
    }
}
