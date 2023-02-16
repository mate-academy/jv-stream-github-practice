package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_PERIOD_BEGIN = 0;
    private static final int INDEX_PERIOD_END = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int periodBegin = Integer.parseInt(period[INDEX_PERIOD_BEGIN]);
        int periodEnd = Integer.parseInt(period[INDEX_PERIOD_END]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodEnd - periodBegin >= MIN_PERIOD_IN_UKRAINE;
    }
}
