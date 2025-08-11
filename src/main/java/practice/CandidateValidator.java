package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = ",";
    private static final String YEAR_RANGE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        int totalYearsInUkraine = Stream.of(candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR))
                .mapToInt(period -> {
                    String[] years = period.split(YEAR_RANGE_SEPARATOR);
                    return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) + 1;
                })
                .sum();
        return totalYearsInUkraine >= MIN_YEARS_IN_UKR;
    }
}
