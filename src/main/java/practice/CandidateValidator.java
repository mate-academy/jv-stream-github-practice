package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getPeriods(candidate) >= 10;
    }

    private int getPeriods(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
    }
}
