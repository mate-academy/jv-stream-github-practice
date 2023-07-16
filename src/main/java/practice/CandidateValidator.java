package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final int PERIOD_UKR_MIN = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= PERIOD_UKR_MIN
                && candidate.getNationality().equals(NATIONALITY_UKR)
                && candidate.isAllowedToVote()
                && candidate.getNumberOfYears() >= 10;
    }
}
