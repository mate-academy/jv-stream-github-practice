package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] periodsSplit = candidate.getPeriodsInUkr().split("-");

        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(periodsSplit[1]) - Integer.parseInt(periodsSplit[0]) >= 10;
    }
    //write your code here
}
