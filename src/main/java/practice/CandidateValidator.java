package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALIDATE_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALIDATE_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriodsInUkraine(candidate.getPeriodsInUkr()) >= YEARS_IN_UKRAINE;
    }

    private int getPeriodsInUkraine(String period) {
        String[] yearsFromPeriod = period.split("-");
        return Integer.parseInt(yearsFromPeriod[1]) - Integer.parseInt(yearsFromPeriod[0]);
    }
}
