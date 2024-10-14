package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_COUNTRY = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        try {
            String[] periods = candidate.getPeriodsInUkr().split("-");
            int startYear = Integer.parseInt(periods[START_YEAR_INDEX]);
            int endYear = Integer.parseInt(periods[END_YEAR_INDEX]);
            return (endYear - startYear) >= MIN_YEARS_IN_COUNTRY;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid period format for candidate: "
                    + candidate.getPeriodsInUkr(), e);
        }
    }
}
