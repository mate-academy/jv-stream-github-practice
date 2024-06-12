package practice;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && hasLivedInUkraineForRequiredYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForRequiredYears(String periodsInUkr) {
        List<String> periods = Arrays.asList(periodsInUkr.split(","));
        int totalYears = periods.stream()
                .map(this::parsePeriod)
                .mapToInt(Period::getYears)
                .sum();
        return totalYears >= REQUIRED_YEARS_IN_UKRAINE;
    }

    private Period parsePeriod(String period) {
        String[] years = period.split("-");
        LocalDate startDate = LocalDate.of(Integer.parseInt(years[0]), 1, 1);
        LocalDate endDate = LocalDate.of(Integer.parseInt(years[1]), 12, 31);
        return Period.between(startDate, endDate);
    }
}
