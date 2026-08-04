package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");

        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);

        return endYear - startYear >= REQUIRED_YEARS_IN_UKRAINE;
    }
}
