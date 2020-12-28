package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        int fromPeriod = Integer.parseInt(candidate.getPeriodsInUkr().substring(0,4));
        int toPeriod = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().length() - 4));
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && fromPeriod - toPeriod <= -10;
    }
}
