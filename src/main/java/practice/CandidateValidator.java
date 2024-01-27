package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIODS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && calculatePeriodsInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIODS_IN_UKR) {
            return true;
        } else {
            return false;
        }
    }

    private int calculatePeriodsInUkr(String fromTo) {
        String[] years = fromTo.split("-");
        int fromYear = Integer.parseInt(years[0]);
        int toYear = Integer.parseInt(years[1]);
        return toYear - fromYear;
    }
}
