package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLITERATOR = "-";
    private static final int FROM = 0;
    private static final int TO = 1;
    private static final int VALID_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int firstInd = Integer.parseInt(period[FROM]);
        int secondInd = Integer.parseInt(period[TO]);
        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && secondInd - firstInd >= LIVE_IN_UKR;
    }
}
