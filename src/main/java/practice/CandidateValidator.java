package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String periods = candidate.getPeriodsInUkr();
        int years = Integer.parseInt(periods.split("-")[1])
                - Integer.parseInt(periods.split("-")[0]);

        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && years >= 10;
    }

}
