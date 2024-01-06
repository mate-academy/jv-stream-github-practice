package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int SECOND_PERIOD = 1;
    private static final int FIRST_PERIOD = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase("ukrainian")
                && candidate.getAge() >= 35
                && getPeriodsInUkrAsInt(candidate) >= 10;
    }

    private int getPeriodsInUkrAsInt(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.valueOf(years[SECOND_PERIOD]) - Integer.valueOf(years[FIRST_PERIOD]);
    }
}
