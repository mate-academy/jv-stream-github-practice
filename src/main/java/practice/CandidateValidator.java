package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_OF_LIVING = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsOfLivingInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        int startYear = Integer.parseInt(yearsOfLivingInUkraine[0]);
        int endYear = Integer.parseInt(yearsOfLivingInUkraine[1]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && endYear - startYear >= MIN_PERIOD_OF_LIVING;
    }
}
