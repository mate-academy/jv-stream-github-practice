package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getPeriodsInUkraine(candidate.getPeriodsInUkr()) > 10;
    }

    private int getPeriodsInUkraine(String period) {
        String[] yearsInUkraine = period.split("-");
        return Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0]);
    }
}
