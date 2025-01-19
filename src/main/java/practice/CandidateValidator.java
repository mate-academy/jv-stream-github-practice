package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    // National for being candidate
    private static final String neededNational = "Ukrainian";
    // Minimum required age for being candidate
    private static final int neededAge = 35;
    // Minimum required years for being candidate
    private static final int neededPeriod = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null
                || !candidate.getNationality().equals(neededNational)
                || candidate.getAge() < neededAge
                || !candidate.isAllowedToVote()) {
            return false;
        }
        try {
            List<Integer> periodInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .toList();
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

