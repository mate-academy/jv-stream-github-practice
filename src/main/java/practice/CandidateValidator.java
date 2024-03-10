package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;
import model.Nationality;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final Nationality REQUIRED_NATIONALITY = Nationality.UA;
    private static final String PERIODS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(REQUIRED_NATIONALITY.getName(), candidate.getNationality())
                && parseYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int parseYearsInUkraine(String periods) {
        String[] parsedPeriods = periods.split(PERIODS_SEPARATOR);
        return Integer.parseInt(parsedPeriods[1]) - Integer.parseInt(parsedPeriods[0]);
    }
}
