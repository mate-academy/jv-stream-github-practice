package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROMAGE = 35;
    private static final int YEARSINUKRAINE = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String PERIOD_DELIMITER = "-";
    private static final int START_INDEX_YEAR = 0;
    private static final int END_INDEX_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= FROMAGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)) {
            int[] split = Arrays.stream(candidate.getPeriodsInUkr()
                            .split(PERIOD_DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return split[END_INDEX_YEAR] - split[START_INDEX_YEAR] >= YEARSINUKRAINE;
        }
        return false;
    }
}
