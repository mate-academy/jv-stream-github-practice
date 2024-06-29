package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int AGE = 35;
    private static final int DURATION = 10;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        int start = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[START_INDEX]);
        int end = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[END_INDEX]);
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && end - start >= DURATION;
    }
}
