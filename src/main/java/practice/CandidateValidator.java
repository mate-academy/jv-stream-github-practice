package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int ELIGIBILITY_AGE = 35;
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final int POSITION_START_YEAR = 0;
    private static final int POSITION_END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ELIGIBILITY_AGE
                && candidate.isAllowedToVote()
                && ELIGIBLE_NATIONALITY.equals(candidate.getNationality())
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int startYearInUkraine = Integer.parseInt(periodsInUkr[POSITION_START_YEAR]);
        int endYearInUkraine = Integer.parseInt(periodsInUkr[POSITION_END_YEAR]);
        int yearsInUkraine = endYearInUkraine - startYearInUkraine;
        return yearsInUkraine > REQUIRED_YEARS_IN_UKRAINE;
    }
}
