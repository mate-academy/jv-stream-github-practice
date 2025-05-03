package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    private boolean livedInUkrForTenYears(Candidate candidate) {
        String periods = candidate.getPeriodsInUkr();
        if (periods != null && periods.contains("-")) {
            String[] years = periods.split("-");
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            return (endYear - startYear >= 10);
        }
        return false;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && livedInUkrForTenYears(candidate);
    }
}
