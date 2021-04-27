package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_OF_LIFE_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;
    private static final String SPLIT_CONSTANT = "-";
    private static final int FIRST_ELEMENT_OF_ARRAY = 1;
    private static final int ZERO_ELEMENT_OF_ARRAY = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SPLIT_CONSTANT);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && (Integer.parseInt(period[FIRST_ELEMENT_OF_ARRAY])
                - Integer.parseInt(period[ZERO_ELEMENT_OF_ARRAY]) >= MIN_PERIOD_OF_LIFE_IN_UKRAINE)
                && candidate.isAllowedToVote();
    }
}
