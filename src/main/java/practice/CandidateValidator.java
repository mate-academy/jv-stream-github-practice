package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private int minAgeOfCandidate = 35;
    private String nationalityOfCandidate = "Ukrainian";
    private int minPeriod = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= minAgeOfCandidate
                && candidate.getNationality().equals(nationalityOfCandidate)
                && candidate.isAllowedToVote()
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]) >= minPeriod;
    }
}
