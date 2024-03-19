package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKR_NATIONALITY = "Ukrainian";
    private static final int START_AGE = 35;
    private static final int MIN_PERIOD = 10;

    public CandidateValidator() {
    }

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(period[0]);
        int endYear = Integer.parseInt(period[1]);
        int periodInUA = endYear - startYear;
        return candidate.getAge() >= START_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKR_NATIONALITY)
                && periodInUA >= MIN_PERIOD;
    }
}
