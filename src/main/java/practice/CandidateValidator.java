package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate c) {
        if (c == null) {
            return false;
        }
        if (c.getAge() < REQUIRED_AGE) {
            return false;
        }
        if (!REQUIRED_NATIONALITY.equals(c.getNationality())) {
            return false;
        }
        if (!c.isAllowedToVote()) {
            return false;
        }
        try {
            int totalYears = Arrays.stream(c.getPeriodsInUkr().split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .mapToInt(period -> {
                        String[] years = period.split("-");
                        int start = Integer.parseInt(years[0].trim());
                        int end = Integer.parseInt(years[1].trim());
                        return Math.max(0, end - start);
                    })
                    .sum();
            return totalYears >= REQUIRED_YEARS_IN_UKR;
        } catch (Exception e) {
            return false;
        }
    }
}
