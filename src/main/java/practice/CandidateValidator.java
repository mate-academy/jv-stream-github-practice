package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_YEAR_IN_UKRAINE = 10;
    private static final String COUNTRY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split("-");
        if (Integer.parseInt(dates[1])
                - Integer.parseInt(dates[0]) >= MIN_YEAR_IN_UKRAINE) {
            return MIN_AGE_CANDIDATE <= candidate.getAge() && candidate.isAllowedToVote()
                    && candidate.getNationality() != null
                    && candidate.getNationality().equals(COUNTRY);
        }
        return false;
    }
}
