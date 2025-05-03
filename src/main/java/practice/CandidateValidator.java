package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]);
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality()) && periodInUkr >= 10;
    }
}
