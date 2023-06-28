package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int TIME_FROM_IN_UKRAINE = 0;
    private static final int TIME_TO_IN_UKRAINE = 1;
    private static final int REQUIRED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), "Ukrainian")
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        int startYear = Integer.parseInt(years[TIME_FROM_IN_UKRAINE]);
        int endYear = Integer.parseInt(years[TIME_TO_IN_UKRAINE]);
        int yearsInUkraine = endYear - startYear + 1;
        return yearsInUkraine >= 10;
    }
}

