package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return Stream.of(candidate)
                .filter(c -> c != null)
                .filter(c -> c.getAge() >= REQUIRED_AGE)
                .filter(c -> REQUIRED_NATIONALITY.equals(c.getNationality()))
                .filter(Candidate::isAllowedToVote)
                .filter(c -> Arrays.stream(c.getPeriodsInUkr().split(","))
                        .map(String::trim)
                        .filter(period -> !period.isEmpty())
                        .mapToInt(period -> {
                            String[] years = period.split("-");
                            if (years.length != 2) {
                                return 0;
                            }
                            try {
                                int startYear = Integer.parseInt(years[0].trim());
                                int endYear = Integer.parseInt(years[1].trim());
                                return Math.max(0, endYear - startYear);
                            } catch (NumberFormatException e) {
                                return 0;
                            }
                        })
                        .sum() >= REQUIRED_YEARS_IN_UKR)
                .findAny()
                .isPresent();
    }
}



