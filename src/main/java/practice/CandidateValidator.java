package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MINIMUM_AGE = 35;
    private static final String CANDIDATE_REQ_NATIONALITY = "Ukrainian";
    private static final int CANDIDATE_MUST_LIVED_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        int totalYears = Arrays.stream(candidate.getPeriodsInUkr().split("\\s*,\\s*"))
                .mapToInt(period -> {
                    String[] years = period.split("\\s*-\\s*");
                    int start = Integer.parseInt(years[0]);
                    int end = Integer.parseInt(years[1]);
                    return end - start + 1;
                })
                .sum();
        if (candidate.getAge() >= CANDIDATE_MINIMUM_AGE
                && CANDIDATE_REQ_NATIONALITY.equals(candidate.getNationality())
                && totalYears >= CANDIDATE_MUST_LIVED_YEARS
                && candidate.isAllowedToVote()) {
            return true;
        }
        return false;
    }
}
