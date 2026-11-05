package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null || candidate.getPeriodsInUkr() == null) {
            return false;
        }
        String[] years = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(years[0].trim());
        int endYear = Integer.parseInt(years[1].trim());
        int totalYears = (endYear - startYear);
        boolean hasEnoughYears = totalYears >= MIN_YEARS_IN_UKRAINE;
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && hasEnoughYears;
    }
}
