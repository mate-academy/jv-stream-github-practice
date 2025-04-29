package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int AGE_EDGE = 35;
    public static final int YEARS_IN_UKR = 10;
    public static final String UKR_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
        int livedInUkr = Integer.parseInt(yearsInUkr[1]) - Integer.parseInt(yearsInUkr[0]);
        return candidate.getAge() >= AGE_EDGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKR_NATIONALITY)
                && livedInUkr > YEARS_IN_UKR;
    }
}
