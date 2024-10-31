package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENT = 35;
    private static final int FIRST_PART = 0;
    private static final int SECOND_PART = 1;
    private static final int MIN_AGE_TO_BE_IN_UKRAINE_FOR_PRESIDENT = 10;
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (isCandidateNull(candidate)) {
            return false;
        }

        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        if (years.length != 2) {
            return false;
        }

        int startYear = Integer.parseInt(years[FIRST_PART]);
        int endYear = Integer.parseInt(years[SECOND_PART]);

        int yearsInUkraine = endYear - startYear;

        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && yearsInUkraine >= MIN_AGE_TO_BE_IN_UKRAINE_FOR_PRESIDENT;
    }

    private boolean isCandidateNull(Candidate candidate) {
        return candidate == null || candidate.getNationality() == null
                || candidate.getPeriodsInUkr() == null || candidate.getPeriodsInUkr().isEmpty();
    }
}
