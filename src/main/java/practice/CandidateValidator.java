package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] periodSeparated = periodsInUkr.split("-");
        return Integer.parseInt(
                periodSeparated[1]) - Integer.parseInt(periodSeparated[0]);
    }
}
