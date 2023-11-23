package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_CANDIDATE_AGE = 35;
    private static final int VALID_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && calculateYearsInUkr(candidate.getPeriodsInUkr()) >= VALID_PERIOD_IN_UKR;
    }

    private int calculateYearsInUkr(String periodInUkr) {
        String[] partOfPeriodInUkr = periodInUkr.split("-");
        int startYearInUkr = Integer.parseInt(partOfPeriodInUkr[0]);
        int endYearInUkr = Integer.parseInt(partOfPeriodInUkr[1]);
        return endYearInUkr - startYearInUkr;
    }
}
