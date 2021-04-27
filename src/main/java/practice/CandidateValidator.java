package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";
    private static final int LIVE_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split(SPLITTER);
        int isCandidateLiveEnoughYears = Integer.parseInt(yearsInUkr[1])
                - Integer.parseInt(yearsInUkr[0]);
        return isCandidateLiveEnoughYears >= LIVE_IN_UKR
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
