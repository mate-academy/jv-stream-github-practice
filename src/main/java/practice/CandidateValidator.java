package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && calculatePeriodInUkraine(candidate) >= 10;
    }

    private int calculatePeriodInUkraine(Candidate candidate) {
        String[] stringDates = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(stringDates[1]) - Integer.parseInt(stringDates[0]);
    }
}
