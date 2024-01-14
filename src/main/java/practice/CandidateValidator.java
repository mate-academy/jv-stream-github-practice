package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWABLE_AGE = 35;
    private static final int MIN_YEARS_OF_RESIDENCE = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String HYPHEN = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_ALLOWABLE_AGE
                && candidate.isAllowedToVote()
                && UKRAINIAN_NATIONALITY.equals(candidate.getNationality())
                && getNumberOfYearsInUkraine(candidate);
    }

    private boolean getNumberOfYearsInUkraine(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(HYPHEN);
        int numberOfYearsInUkraine =
                Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0]);
        return numberOfYearsInUkraine >= MIN_YEARS_OF_RESIDENCE;
    }
}
