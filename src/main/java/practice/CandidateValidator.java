package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int SPLIT_INDEX_0 = 0;
    private static final int SPLIT_INDEX_1 = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int periodInUkraineFrom
                = Integer.parseInt(split[SPLIT_INDEX_0]);
        int periodInUkraineTo
                = Integer.parseInt(split[SPLIT_INDEX_1]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && periodInUkraineTo
                - periodInUkraineFrom
                >= YEARS_IN_UKRAINE;
    }
}
