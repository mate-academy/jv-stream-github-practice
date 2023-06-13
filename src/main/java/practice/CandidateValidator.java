package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int TIME_LIVE_IN_UA = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && periodsInUkraine(candidate);
    }

    public static boolean periodsInUkraine(Candidate candidate) {
        String[] timeInUkr = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(timeInUkr[1]) - Integer.parseInt(timeInUkr[0]) > TIME_LIVE_IN_UA;
    }
}
