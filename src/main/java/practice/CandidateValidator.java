package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int yearInUkr = Integer.parseInt(split[1]) - Integer.parseInt(split[0]);
        if (candidate.isAllowedToVote() && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian") && yearInUkr >= 10) {
            return true;
        }
        return false;
    }
}
