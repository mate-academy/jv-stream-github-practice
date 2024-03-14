package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] yearFromTo = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(yearFromTo[1]) - Integer.parseInt(yearFromTo[0]);

        return candidate.getAge() >= 35 && candidate.getNationality().equals("Ukrainian")
                && period >= 10 && candidate.isAllowedToVote();
    }
}
