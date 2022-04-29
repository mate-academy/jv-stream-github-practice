package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_REQUIRED_AGE = 35;
    private static final int YEARS_LIVED_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int yearInUkr = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
        if (candidate.isAllowedToVote() && candidate.getAge() >= MIN_REQUIRED_AGE
                && candidate.getNationality().equals("Ukrainian")
                && yearInUkr >= YEARS_LIVED_IN_UKR) {
            return true;
        }
        return false;
    }
}
