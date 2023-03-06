package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    public static final int MIN_YEARS_LIVING_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!candidate.getNationality().equals(NATIONALITY_UKRAINIAN)) {
            return false;
        }
        int startLivingInUkr = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int endLivingInUkr = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        if (endLivingInUkr - startLivingInUkr < MIN_YEARS_LIVING_IN_UKR) {
            return false;
        }
        return true;
    }
}
