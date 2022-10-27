package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_DATA_BEFORE_SPLIT = 0;
    private static final int INDEX_DATA_AFTER_SPLIT = 1;
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    private static final String DATA_SEPARATOR = "-";
    private static final int MIN_AGE_VALUE = 35;
    private static final int MIM_TERM_LIVING_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int beforeDataSplit = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(DATA_SEPARATOR)[INDEX_DATA_BEFORE_SPLIT]);
        int afterDataSplit = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(DATA_SEPARATOR)[INDEX_DATA_AFTER_SPLIT]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && candidate.getAge() >= MIN_AGE_VALUE
                && beforeDataSplit - afterDataSplit >= MIM_TERM_LIVING_IN_UKRAINE;
    }
}
