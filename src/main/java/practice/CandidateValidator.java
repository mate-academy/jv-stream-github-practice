package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_OF_THE_CANDIDATE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_LIVING_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_OF_THE_CANDIDATE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), NATIONALITY)
                && livedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineFor10Years(String periodsInUkr) {
        if (periodsInUkr == null || !periodsInUkr.matches("\\d+\\s*-\\s*\\d+")) {
            System.out.println("Invalid period format!"
                    + " Please enter correct value with format: 'yyyy-yyyy'");
        } else {
            String[] years = periodsInUkr.split("-");
            try {
                int startYear = Integer.parseInt(years[0]);
                int endYear = Integer.parseInt(years[1]);
                return (endYear - startYear >= MIN_LIVING_IN_COUNTRY);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid year format!");
            }
        }
        return false;
    }
}
