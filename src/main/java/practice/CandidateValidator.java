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
        String[] splitData = candidate.getPeriodsInUkr().split(DATA_SEPARATOR);
        int periodLivingInUkraine = Integer.parseInt(splitData[INDEX_DATA_AFTER_SPLIT])
                - Integer.parseInt(splitData[INDEX_DATA_BEFORE_SPLIT]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && candidate.getAge() >= MIN_AGE_VALUE
                && periodLivingInUkraine >= MIM_TERM_LIVING_IN_UKRAINE;
    }
}
