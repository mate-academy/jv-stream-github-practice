package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final Integer AGE_FROM = 35;
    private static final String NATIONAL = "Ukrainian";
    private static final Integer TIME_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= AGE_FROM && candidate.getNationality().equals(NATIONAL)) {
            return national(candidate) && candidate.isAllowedToVote();
        }
        return false;
    }

    private boolean national(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
        return period(yearsInUkr[0], yearsInUkr[1]);
    }

    private boolean period(String from, String to) {
        return Integer.parseInt(to) - Integer.parseInt(from) >= TIME_IN_UKR;
    }
}
