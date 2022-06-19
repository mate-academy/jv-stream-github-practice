package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && numberOfYearsInUkr(candidate.getPeriodsInUkr()) >= 10;
    }

    private int numberOfYearsInUkr(String periodsInUkr) {
        String[] yearsString = periodsInUkr.split("-");
        return Integer.parseInt(yearsString[1]) - Integer.parseInt(yearsString[0]);
    }
}
