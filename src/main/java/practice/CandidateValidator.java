package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] temporary = candidate.getPeriodsInUkr().split("-");
        int[] yearsOfStayInUkraine = new int[2];
        for (int i = 0; i < temporary.length; i++) {
            yearsOfStayInUkraine[i] = Integer.parseInt(temporary[i]);
        }
        return candidate.getAge() >= MIN_AGE && candidate.getNationality().equals(NATIONALITY)
                && yearsOfStayInUkraine[1] - yearsOfStayInUkraine[0] >= MIN_PERIOD
                && candidate.isAllowedToVote();
    }
}
