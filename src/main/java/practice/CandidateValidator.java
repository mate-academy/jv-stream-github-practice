package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int AGE = 35;
    public static final String UKRAINIAN = "Ukrainian";
    public static final int LIVE_FOR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return isValid(candidate, AGE, UKRAINIAN, LIVE_FOR);
    }

    private static boolean isValid(Candidate c, int age, String nationality, int required) {
        return c.getAge() >= age
                && c.isAllowedToVote()
                && nationality.equals(c.getNationality())
                && liveMoreThan(c, required);
    }

    private static boolean liveMoreThan(Candidate candidate, int required) {
        String[] period = candidate.getPeriodsInUkr()
                .trim()
                .split("\\s*-\\s*");
        int diff = Math.abs(
                Integer.parseInt(period[1])
                        - Integer.parseInt(period[0]));
        return diff >= required;
    }
}
