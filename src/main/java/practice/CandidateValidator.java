package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_AGE = 35;
    private static final int PERIODS_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_OF_RESIDENCE = 0;
    private static final int END_OF_RESIDENCE = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= FROM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[END_OF_RESIDENCE])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[START_OF_RESIDENCE])
                > PERIODS_IN_UKR;
    }
}
