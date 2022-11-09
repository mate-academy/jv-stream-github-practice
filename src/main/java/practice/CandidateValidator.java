package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int NEEDED_PERIOD_IN_UKR = 10;
    private static final int MIN_CANDIDATES_AGE = 35;
    private static final String NEEDED_NATIONALITY = "Ukrainian";
    private static final int INDEX_BEGIND = 0;
    private static final int INDEX_END = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return (Integer.parseInt(period[INDEX_END]) - Integer
                .parseInt(period[INDEX_BEGIND]) >= NEEDED_PERIOD_IN_UKR)
                && candidate.getNationality().equals(NEEDED_NATIONALITY)
                && candidate.getAge() >= MIN_CANDIDATES_AGE
                && candidate.isAllowedToVote();
    }
}
