package practice;

import ecxeption.CandidateValidationException;
import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        if (years.length != 2) {
            throw new CandidateValidationException("Period data is incorrect: "
                    + candidate.getPeriodsInUkr());
        }
        int startYear = Integer.parseInt(years[START_YEAR_INDEX].trim());
        int endYear = Integer.parseInt(years[END_YEAR_INDEX].trim());
        if (startYear > endYear) {
            throw new CandidateValidationException("Incorrect sequence of years: "
                    + candidate.getPeriodsInUkr());
        }
        int period = endYear - startYear;

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), UKRAINIAN_NATIONALITY)
                && period >= MIN_PERIOD_IN_UKRAINE;
    }
}
