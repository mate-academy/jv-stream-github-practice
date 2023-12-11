package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int EDGE_AGE = 35;
    private static final int DEF_LIVE_IN_UKR = 10;
    private static final int INDEX_FROM = 0;
    private static final int INDEX_TO = 1;
    private static final String NATIONALITY_OF_UKR = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int periodInUkr;
        try {
            periodInUkr = Integer.parseInt(periods[INDEX_TO])
                        - Integer.parseInt(periods[INDEX_FROM]);
        } catch (RuntimeException e) {
            throw new RuntimeException("Candidate has some problems "
                                     + "with periods of live in Ukraine");
        }
        return candidate.isAllowedToVote()
                && candidate.getAge() >= EDGE_AGE
                && candidate.getNationality().equals(NATIONALITY_OF_UKR)
                && periodInUkr >= DEF_LIVE_IN_UKR;
    }
}
