package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY_UKR)
                && candidate.isAllowedToVote()
                && candidate.getPeriodInUkrDuration() >= 10;
    }
}
