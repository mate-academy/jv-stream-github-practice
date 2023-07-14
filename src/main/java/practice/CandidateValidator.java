package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator {
    //write your code here
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final int PERIOD_UKR_MIN = 35;

    public Predicate<Candidate> isCandidate() {
        return p -> p.getAge() >= PERIOD_UKR_MIN && p.getNationality().equals(NATIONALITY_UKR)
                && p.isAllowedToVote() && p.getNumberOfYears() >= 10;
    }
}
