package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LIMIT = 35;
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int YEARS_DIFFERENCE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedYears = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        int[] yearsFromTo = new int[]
                {Integer.parseInt(splitedYears[ZERO_INDEX]),
                        Integer.parseInt(splitedYears[FIRST_INDEX])};
        return candidate.getAge() >= AGE_LIMIT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsFromTo[FIRST_INDEX] - yearsFromTo[ZERO_INDEX] >= YEARS_DIFFERENCE;
    }
}
