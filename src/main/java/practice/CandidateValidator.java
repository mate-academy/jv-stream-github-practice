package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int TIME_LIVE_IN_UA = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && checkPeriodsInUkraine(candidate);
    }

    public boolean checkPeriodsInUkraine(Candidate candidate) {
        String[] timeInUkr = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(timeInUkr[TO_YEAR])
                - Integer.parseInt(timeInUkr[FROM_YEAR]) > TIME_LIVE_IN_UA;
    }
}
