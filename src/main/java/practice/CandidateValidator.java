package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")) {
            int startYear = Integer.parseInt(
                    candidate.getPeriodsInUkr().split("-")[0]);
            int endYear = Integer.parseInt(
                    candidate.getPeriodsInUkr().split("-")[1]);
            return endYear - startYear >= 10;
        }
        return false;
    }
}
