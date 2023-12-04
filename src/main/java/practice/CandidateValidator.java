package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LIMIT = 35;
    private static final int PERIOD_LIMIT = 10;
    private static final String NATIONALITY_REQUIREMENT = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_LIMIT
                && candidate.isAllowedToVote()
                && NATIONALITY_REQUIREMENT.equals(candidate.getNationality())
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= PERIOD_LIMIT;
    }

    private int calculateYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear;
    }
}
