package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int YEARS_OF_RESIDENCE = 10;
    public static final int MINIMUM_AGE = 35;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIODS_DELIMITER = ",";
    private static final String YEARS_DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MINIMUM_AGE
                || !candidate.isAllowedToVote()
                || !REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }
        return hasMinimumResidence(candidate, YEARS_OF_RESIDENCE);
    }

    private boolean hasMinimumResidence(Candidate c, int yearsOfResidence) {
        return Stream.of(c.getPeriodsInUkr().split(PERIODS_DELIMITER))
                .map(String::trim)
                .mapToInt(range -> {
                    String[] years = range.split(YEARS_DELIMITER);
                    return Integer.parseInt(years[1].trim())
                            - Integer.parseInt(years[0].trim());
                })
                .sum() >= yearsOfResidence;
    }
}
