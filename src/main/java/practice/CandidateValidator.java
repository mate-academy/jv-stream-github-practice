package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_CANDIDATE_PERIOD_IN_UKR = 10;
    private static final String PERIOD_IN_UKR_SPLITERATOR = "-";
    private static final int PERIOD_IN_UKR_STARTS = 0;
    private static final int PERIOD_IN_UKR_ENDS = 1;
    private static final String ALLOWED_CANDIDATE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(PERIOD_IN_UKR_SPLITERATOR);
        int periodInUkr = Integer.parseInt(periodsInUkr[PERIOD_IN_UKR_ENDS])
                - Integer.parseInt(periodsInUkr[PERIOD_IN_UKR_STARTS]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(ALLOWED_CANDIDATE_NATIONALITY)
                && periodInUkr > MIN_CANDIDATE_PERIOD_IN_UKR;
    }
}
