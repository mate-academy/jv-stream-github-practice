package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int start = Integer.parseInt(years[0]);
        int end = Integer.parseInt(years[1]);
        return candidate.getAge() >= AGE
                && NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote()
                && (end - start) >= LIVING_PERIOD;
    }
}
