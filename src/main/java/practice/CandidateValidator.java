package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && Objects.equals(candidate.getNationality(), "Ukrainian")
                && candidate.isAllowedToVote()
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodInUkraine) {
        String[] periods = periodInUkraine.split("-");
        if (periods.length != 2) {
            return false;
        }
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        return (endYear - startYear) >= 10;
    }
}
