package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String CITIZENSHIP = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE
                && Objects.equals(candidate.getNationality(), CITIZENSHIP);
    }
}
