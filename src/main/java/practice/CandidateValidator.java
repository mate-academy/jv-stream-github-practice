package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getLastYear(candidate.getPeriodsInUkr())
                - getFirstYear(candidate.getPeriodsInUkr()) >= 10;
    }

    private int getFirstYear(String period) {
        String[] dates = period.split("-");
        return Integer.parseInt(dates[FIRST_INDEX]);
    }

    private int getLastYear(String period) {
        String[] dates = period.split("-");
        return Integer.parseInt(dates[SECOND_INDEX]);
    }
}
