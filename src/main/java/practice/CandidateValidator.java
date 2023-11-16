package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    public static final int MINIMAL_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MINIMAL_PERIOD_DURATION = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getCandidatePeriodInUkrDuration(candidate) >= MINIMAL_PERIOD_DURATION;
    }

    private static Integer getCandidatePeriodInUkrDuration(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
