package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_LIVING_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_CANDIDATE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getLivingYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_LIVING_PERIOD;
    }

    private static int getLivingYearsInUkraine(String period) {
        String[] livingYears = period.split("-");
        return Integer.parseInt(livingYears[1]) - Integer.parseInt(livingYears[0]);
    }
}
