package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 10;
    private static final int YEARSAGE = 2;
    private static final int OLDER_AGE = 35;

    private boolean isResidentFor10Years(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        if (years.length != YEARSAGE) {
            return false;
        }

        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);

        return endYear - startYear >= ALLOWED_AGE;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= OLDER_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && isResidentFor10Years(candidate.getPeriodsInUkr());
    }
}
