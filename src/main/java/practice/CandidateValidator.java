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
                && liveTen(candidate.getPeriodsInUkr());
    }

    private boolean liveTen(String period) {
        String[] periods = period.split("-");
        if (periods.length != 2) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(periods[0]);
            int endYear = Integer.parseInt(periods[1]);
            return endYear - startYear >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
