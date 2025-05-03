package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_REQUIRED_AGE = 35;
    private static final int CANDIDATE_REQUIRED_YEARS_IN_UA = 10;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int totalYearsInUkr = Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]);
        return candidate.getAge() >= CANDIDATE_MIN_REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && totalYearsInUkr >= CANDIDATE_REQUIRED_YEARS_IN_UA;
    }
}
