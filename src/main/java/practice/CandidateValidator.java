package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_LIVE_IN_UA = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkPeriod(candidate.getPeriodsInUkr());
    }

    private boolean checkPeriod(String period) {
        String[] split = period.split("-");
        int yearFrom = Integer.parseInt(split[0]);
        int yearTo = Integer.parseInt(split[1]);
        return yearTo
                - yearFrom
                >= MIN_LIVE_IN_UA;
    }
}
