package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final int MIN_PERIOD_IN_UKRAINE = 10;
    public static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && NATIONALITY.equals(c.getNationality())
                && getYearsInUkraine(c.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getYearsInUkraine(String period) {
        String[] parts = period.split("-");
        int start = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);
        return end - start;
    }
}
