package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_MIN_AGE = 35;
    private static final int REQUIRED_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.isAllowedToVote()
                && getYearsLivedInUkraine(candidate) >= REQUIRED_YEARS;
    }

    private int getYearsLivedInUkraine(Candidate candidate) {
        String[] splitedPeriods = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(splitedPeriods[1]) - Integer.parseInt(splitedPeriods[0]);
    }
}
