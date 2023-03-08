package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIREMENT_MIN_AGE = 35;
    private static final String REQUIREMENT_NATIONALITY = "Ukrainian";
    private static final int REQUIREMENT_MIN_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIREMENT_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIREMENT_NATIONALITY)
                && isLiveInUkrFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean isLiveInUkrFor10Years(String periodsInUkr) {
        String[] split = periodsInUkr.split("-");
        int differentYears = Integer.parseInt(split[1]) - Integer.parseInt(split[0]);
        return differentYears > REQUIREMENT_MIN_YEARS_IN_UKR;
    }
}
