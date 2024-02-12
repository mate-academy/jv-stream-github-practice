package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AFTER_35_YEARS = 35;
    private static final String UKRAINIAN = "Ukrainian";
    private static final int LIVE_IN_UKRAINE_10_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        int age = candidate.getAge();
        String nationality = candidate.getNationality();
        boolean allowedToVote = candidate.isAllowedToVote();
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int sumPerInUkr = Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]);

        return age >= AFTER_35_YEARS
                && allowedToVote
                && nationality.equals(UKRAINIAN)
                && sumPerInUkr >= LIVE_IN_UKRAINE_10_YEARS;
    }
}
