package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";
    private static final int REQUIRED_AGE = 35;
    private static final int AGE_TO_LIVE_IN_UKRAINE = 10;
    private static final int STARTED_TO_LIVE = 0;
    private static final int ENDED_TO_LIVE = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        int firstPart = Integer.parseInt(periodsInUkraine[STARTED_TO_LIVE]);
        int secondPart = Integer.parseInt(periodsInUkraine[ENDED_TO_LIVE]);
        return candidate.getAge() >= REQUIRED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (secondPart - firstPart) > AGE_TO_LIVE_IN_UKRAINE;
    }
}
