package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null || candidate.getPeriodsInUkr() == null) {
            return false;
        }
        String[] years = candidate.getPeriodsInUkr().split("-");
        if (years.length != 2) {
            return false;
        }
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        int yearsLived = endYear - startYear;
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && yearsLived >= MIN_LIVE_IN_UKRAINE
                && NATIONALITY.equals(candidate.getNationality());
    }
}
