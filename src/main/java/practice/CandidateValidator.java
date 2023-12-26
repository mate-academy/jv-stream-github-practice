package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()
                || candidate.getAge() < MIN_AGE
                || !candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }

        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);

        return endYear - startYear + 1 >= MIN_YEARS_IN_UKRAINE;
    }
}
