package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static boolean checkCandidate(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(yearsInUkraine[1])
                - Integer.parseInt(yearsInUkraine[0]) >= 10
                && candidate.isAllowedToVote();
    }

    @Override
    public boolean test(Candidate candidate) {
        return checkCandidate(candidate);
    }
}
