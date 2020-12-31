package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate {

    @Override
    public boolean test(Object objectCandidate) {
        Candidate candidate = (Candidate) objectCandidate;
        String[] periodYears = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35 && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(periodYears[1]) - Integer.parseInt(periodYears[0]) >= 10
                && candidate.isAllowedToVote();
    }
}
