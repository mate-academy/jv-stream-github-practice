package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_START_TO_LIVE_POSITION = 0;
    private static final int YEAR_FINISH_TO_LIVE_POSITION = 1;
    private static final int MIN_YEARS = 35;
    private static final int MIN_YEARS_LIVE_IN_UKRAINE = 10;
    private static final String REGEX_SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {

        return candidate.getAge() >= MIN_YEARS
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getNumberYearsLivedInUkraine(candidate) >= MIN_YEARS_LIVE_IN_UKRAINE;
    }

    private int getNumberYearsLivedInUkraine(Candidate candidate) {
        int yearStart = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(REGEX_SPLIT)[YEAR_START_TO_LIVE_POSITION]);
        int yearFinish = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(REGEX_SPLIT)[YEAR_FINISH_TO_LIVE_POSITION]);
        return yearFinish - yearStart;
    }
}
