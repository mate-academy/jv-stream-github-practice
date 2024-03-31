package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] startAndEndPeriod = candidate.getPeriodsInUkr().split("-");
        int periodInUk = Integer.parseInt(startAndEndPeriod[1])
                - Integer.parseInt(startAndEndPeriod[0]);
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && periodInUk >= 10;
    }
}
