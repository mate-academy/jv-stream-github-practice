package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MINIMUM_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MINIMUM_TIME_OF_LIVING_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && tenYearsCheck(candidate);
    }

    private boolean tenYearsCheck(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return (endYear - startYear) >= MINIMUM_TIME_OF_LIVING_IN_UKRAINE;
    }
}
