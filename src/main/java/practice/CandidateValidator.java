package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final String UKRAINIAN = "Ukrainian";
    private static final String LINE_REGEX = "-";
    private static final int YEARS_IN = 10;
    private static final int INDEX_FOR_END = 1;
    private static final int INDEX_FOR_BEGIN = 0;

    @Override
    public boolean test(Candidate candidate) {
        int[] periodsInt = Arrays.stream(candidate.getPeriodsInUkr().split(LINE_REGEX))
                .mapToInt(Integer::parseInt)
                .toArray();
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && (periodsInt[INDEX_FOR_END] - periodsInt[INDEX_FOR_BEGIN]) >= YEARS_IN;
    }
}
