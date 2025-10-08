package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && getYearsLivedInUkraine(candidate) >= 10;
    }

    private int getYearsLivedInUkraine(Candidate candidate) {
        String[] splitedPeriods = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(splitedPeriods[1]) - Integer.parseInt(splitedPeriods[0]);
    }
}
