package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String CITIZENSHIP = "Ukrainian";
    private static final String YEAR_SEPARATOR = "-";
    private static final int YEARS_LIVING_LIMIT = 10;
    private static final int AGE_LIMIT = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(YEAR_SEPARATOR);
        return (candidate.getAge() >= AGE_LIMIT)
                && candidate.isAllowedToVote()
                && (Objects.equals(candidate.getNationality(), CITIZENSHIP))
                && (Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0])
                >= YEARS_LIVING_LIMIT);
    }
}
