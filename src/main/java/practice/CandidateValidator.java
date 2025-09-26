package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && hasLivedEnough(candidate);
    }

    private boolean hasLivedEnough(Candidate candidate) {
        if (candidate.getPeriodsInUkr() == null || candidate.getPeriodsInUkr().isBlank()) {
            return false;
        }
        return Arrays.stream(candidate.getPeriodsInUkr().split(","))
                .map(String::trim)
                .map(period -> period.split("-"))
                .filter(years -> years.length == 2)
                .map(years -> {
                    try {
                        int fromYear = Integer.parseInt(years[0].trim());
                        int toYear = Integer.parseInt(years[1].trim());
                        return toYear - fromYear;
                    } catch (NumberFormatException e) {
                        return -1;
                    }
                })
                .anyMatch(duration -> duration >= MIN_YEARS_IN_UKR);
    }
}
