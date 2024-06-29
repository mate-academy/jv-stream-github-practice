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
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int start = Integer.parseInt(periods[START_INDEX]);
        int end = Integer.parseInt(periods[END_INDEX]);
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && countDuration(start, end) >= DURATION;
    }

    private int countDuration(int start, int end) {
        return end - start;
    }
}
