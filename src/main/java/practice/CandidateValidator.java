package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PRESIDENT_AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] arrayString = candidate.getPeriodsInUkr().split("-");
        int asInt = Arrays.stream(arrayString)
                .mapToInt(Integer::parseInt)
                .reduce(((left, right) -> right - left))
                .getAsInt();

        return candidate.getAge() >= PRESIDENT_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getPeriodsInUkr() != null
                && asInt > LIVE_IN_UKRAINE;
    }
}
