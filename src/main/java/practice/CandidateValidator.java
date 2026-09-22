package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_BECOME_PRESIDENT = 35;
    private static final String NATIONALITY_TO_BECOME_PRESIDENT = "Ukrainian";
    private static final int YEARS_IN_UKRAINE_TO_BECOME_PRESIDENT = 10;

    @Override
    public boolean test(Candidate c) {
        String[] periodsFromTo = c.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(periodsFromTo[1])
                - Integer.parseInt(periodsFromTo[0]);
        return c.getAge() >= MIN_AGE_TO_BECOME_PRESIDENT
                && Objects.equals(c.getNationality(), NATIONALITY_TO_BECOME_PRESIDENT)
                && yearsInUkraine >= YEARS_IN_UKRAINE_TO_BECOME_PRESIDENT
                && c.isAllowedToVote();
    }
}
