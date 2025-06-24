package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DATES_SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(DATES_SPLIT);
        dates[0] = dates[0].trim();
        dates[1] = dates[1].trim();
        int inUkr = Integer.parseInt(dates[1]) - Integer.parseInt(dates[0]) + 1;
        return (candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && inUkr >= 10
                && candidate.isAllowedToVote());
    }
}
