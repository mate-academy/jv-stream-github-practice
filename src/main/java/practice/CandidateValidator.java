package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PRESIDENT_AGE = 35;
    private static final int MIN_YEARS_LIVES_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] dateInUkrData = candidate.getPeriodsInUkr().split("-");
        int beginDateInUkr = Integer.parseInt(dateInUkrData[0]);
        int endDateInUkr = Integer.parseInt(dateInUkrData[1]);
        return candidate.getAge() >= MIN_PRESIDENT_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && endDateInUkr - beginDateInUkr > MIN_YEARS_LIVES_IN_UKRAINE;
    }
}
