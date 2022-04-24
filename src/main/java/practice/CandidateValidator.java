package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATES_MIN_AGE = 35;
    private static final String CANDIDATES_NATIONALITY = "Ukrainian";
    private static final int MIN_TIME_RESIDANCE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split("-");
        if (Integer.parseInt(dates[1]) - Integer.parseInt(dates[0]) >= MIN_TIME_RESIDANCE) {
            return candidate.getAge() >= CANDIDATES_MIN_AGE
                    && Objects.equals(candidate.getNationality(), CANDIDATES_NATIONALITY)
                    && candidate.isAllowedToVote();
        }
        return false;
    }
}
