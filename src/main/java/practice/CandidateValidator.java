package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_AGE = 35;
    private static final String ACTUALLY_NATIONALITY = "Ukrainian";
    private static final int PERIODS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        boolean isOldEnough = candidate.getAge() >= FROM_AGE;
        boolean isAllowedToVote = candidate.isAllowedToVote();
        boolean isUkrainianNationality = candidate.getNationality().equals(ACTUALLY_NATIONALITY);
        String[] period = candidate.getPeriodsInUkr().split("-");
        boolean isPeriodsInUkr = PERIODS_IN_UKR <= (Integer.parseInt(period[1])
                - Integer.parseInt(period[0]));
        return isOldEnough && isAllowedToVote && isPeriodsInUkr && isUkrainianNationality;
    }
}
