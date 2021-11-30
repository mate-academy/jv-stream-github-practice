package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_PRESIDENT = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {

        String[] years = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.getAge() >= MIN_AGE_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
