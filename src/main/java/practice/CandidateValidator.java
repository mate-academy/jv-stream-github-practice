package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private String nationality = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() > 35
                && candidate.isAllowedToVote()
                && nationality.equals(candidate.getNationality())
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.isEmpty()) {
            return false;
        }

        return Arrays.stream(periodsInUkr.split(","))
                .map(String::trim)
                .filter(s -> s.matches("\\d{4}-\\d{4}"))
                .mapToInt(period -> {
                    String[] years = period.split("-");
                    int start = Integer.parseInt(years[0]);
                    int end = Integer.parseInt(years[1]);
                    return end - start;
                })
                .sum() >= 10;
    }

}
