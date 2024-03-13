package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && timeLivedInUkraine(candidate) >= 10;
    }

    private static int timeLivedInUkraine(Candidate candidate) {
        String[] periodDate = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodDate[1]) - Integer.parseInt(periodDate[0]);
    }
    //write your code here
}
