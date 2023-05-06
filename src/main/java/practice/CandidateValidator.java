package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CORRECT_AGE = 35;
    private static final String CORRECT_NATIONALITY = "Ukrainian";
    private static final int MIN_LIVING_AGE_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CORRECT_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CORRECT_NATIONALITY)
                && calculatePeriodInUkraine(candidate.getPeriodsInUkr()
                .split("-"));
    }

    private boolean calculatePeriodInUkraine(String[] periodsInUkr) {
        int startYear = Integer.parseInt(periodsInUkr[0]);
        int endYear = Integer.parseInt(periodsInUkr[1]);
        return endYear - startYear >= MIN_LIVING_AGE_IN_UKR;
    }
}
