package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private Predicate<Candidate> validator = candidate -> {
        String[] parts = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(parts[0]);
        int endYear = Integer.parseInt(parts[1]);
        if (candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && endYear - startYear >= 10) {
            return true;
        }
        return false;
    };

    public Predicate<Candidate> getValidator() {
        return validator;
    }

    @Override
    public boolean test(Candidate candidate) {
        return validator.test(candidate);
    }
}
