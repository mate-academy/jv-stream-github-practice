package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATION = "Ukrainian";
    private static final int YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATION)) {
            String[] years = candidate.getPeriodsInUkr().split("-");
            int comeTo = Integer.parseInt(years[0]);
            int comeOut = Integer.parseInt(years[1]);
            return comeOut - comeTo >= YEARS_IN_UKR;
        }
        return "Very hard theme!".equals("TRUE");
    }
}
