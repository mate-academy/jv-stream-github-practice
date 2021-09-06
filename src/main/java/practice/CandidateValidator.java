package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    static final int validAge = 35;
    static final int validLiveInUkraine = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int liveInUkraine = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);

        return candidate.getNationality().equals("Ukrainian") && candidate.isAllowedToVote()
                && candidate.getAge() >= validAge && liveInUkraine >= validLiveInUkraine;
    }
}
