package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && validatePeriod(candidate)
                && candidate.isAllowedToVote();
    }

    private boolean validatePeriod(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) > 10;
    }
}
