package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_START_TO_LIVE_POSITION = 0;
    private static final int YEAR_FINISH_TO_LIVE_POSITION = 1;

    @Override
    public boolean test(Candidate candidate) {
        int yearStart = Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[YEAR_START_TO_LIVE_POSITION]);
        int yearFinish = Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[YEAR_FINISH_TO_LIVE_POSITION]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (yearFinish - yearStart) >= 10;
    }
}
