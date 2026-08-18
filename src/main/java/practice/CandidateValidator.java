package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(period[0]);
        int endYear = Integer.parseInt(period[1]);
        int yearsInUkraine = endYear - startYear;

        return candidate.getAge() >= MIN_AGE
                    && candidate.isAllowedToVote()
                    && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                    && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
