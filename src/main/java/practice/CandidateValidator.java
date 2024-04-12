package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        boolean checkPeriod = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]) > 10;
        if (candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equalsIgnoreCase("ukrainian")
                && candidate.isAllowedToVote()
                && checkPeriod) {
            return true;
        } else {
            return false;
        }
    }
}
