package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DIVIDED = "-";
    private static final int MIN_YEAR_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate o) {
        if (o.getAge() >= 35
                && o.isAllowedToVote()
                && o.getNationality().equals("Ukrainian")) {
            String[] years = o.getPeriodsInUkr().split(DIVIDED);
            int[] yearsInt = new int[] {Integer.parseInt(years[0]), Integer.parseInt(years[1])};
            return yearsInt[1] - yearsInt[0] >= MIN_YEAR_LIVE_IN_UKRAINE;
        }
        return false;
    }
}
