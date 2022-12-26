package practice;

import java.util.function.Predicate;
import model.Candidate;


public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int ALLOWED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(periods[0]);
        int toYear = Integer.parseInt(periods[1]);
        int totalPeriodInUkraine = toYear - fromYear;
        return candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && candidate.getAge() > MINIMAL_AGE
                && totalPeriodInUkraine >= ALLOWED_PERIOD;
    }
}
