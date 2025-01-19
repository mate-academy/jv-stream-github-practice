package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIREMENT_NATIONALITY = "Ukrainian";
    private static final int REQUIREMENT_AGE = 35;
    private static final int REQUIREMENT_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null
                || !candidate.getNationality().equals(REQUIREMENT_NATIONALITY)
                || candidate.getAge() < REQUIREMENT_AGE
                || !candidate.isAllowedToVote()) {
            return false;
        }
        try {
            List<Integer> periodInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .toList();
            if (periodInUkraine.size() != 2
                    || periodInUkraine.get(1) - periodInUkraine.get(0) < REQUIREMENT_PERIOD_IN_UKR) {
                return false;
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
}

