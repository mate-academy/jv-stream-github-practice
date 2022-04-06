package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getNumberOfYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int getNumberOfYearsInUkraine(String period) {
        return Integer.parseInt(period.split("-")[1]) - Integer.parseInt(period.split("-")[0]);
    }
}
