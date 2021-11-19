package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_TO_LIVE_IN_UKRAINE = 10;
    private static final String IS_UKRAINIAN = "Ukrainian";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] data = candidate.getPeriodsInUkr().split("-");
        int years = Integer.parseInt(data[SECOND_INDEX]) - Integer.parseInt(data[FIRST_INDEX]);
        if (candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(IS_UKRAINIAN)
                && years >= MIN_YEARS_TO_LIVE_IN_UKRAINE) {
            return true;
        }
        return false;
    }
}
