package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodCalculator(candidate) >= 10;
    }

    private int periodCalculator(Candidate candidate) {
        String[] splited = candidate.getPeriodsInUkr().split("-");
        return Integer.valueOf(splited[1]) - Integer.valueOf(splited[0]);
    }
    //write your code here
}
