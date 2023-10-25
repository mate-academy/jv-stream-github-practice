package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_YEARS_IN_UKR = 10;
    private static final int MINIMAL_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0]);
        return yearsInUkr >= REQUIRED_YEARS_IN_UKR
                && candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY);
    }
}
