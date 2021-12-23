package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), "Ukrainian")
                && checkPeriod(candidate.getPeriodsInUkr());
    }

    private boolean checkPeriod(String period) {
        String[] limits = period.split("-");
        int difference = Integer.parseInt(limits[1]) - Integer.parseInt(limits[0]);
        return difference >= 10;
    }
}
