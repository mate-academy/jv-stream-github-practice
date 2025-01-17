package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int neededAge = 35;
    private static final int neededPeriod = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        if (candidate.getAge() < neededAge) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        try {
            List<Integer> periodInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            if (periodInUkraine.size() != 2
                    || periodInUkraine.get(1) - periodInUkraine.get(0) < neededPeriod) {
                return false;
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
}

