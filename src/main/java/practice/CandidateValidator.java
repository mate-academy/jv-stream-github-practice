package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final byte START_YEAR_POSITION = 0;
    private static final byte END_YEAR_POSITION = 1;
    private static final byte MIN_YEARS_IN_UKRAINE = 10;
    private static final byte MIN_AGE = 35;

    private Predicate<Candidate> validator = candidate -> {
        String[] parts = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(parts[START_YEAR_POSITION]);
        int endYear = Integer.parseInt(parts[END_YEAR_POSITION]);
        if (candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && endYear - startYear >= MIN_YEARS_IN_UKRAINE) {
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
