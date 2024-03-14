package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int LIVE_IN_UKR = 10;
    public static final String NATIONALITY = "Ukrainian";
    private static final int VOTE_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        boolean isElegibleAgeToVote = candidate.getAge() >= VOTE_AGE;
        boolean isElegibleLiveInUkr = periodLiveInUkr(candidate);
        boolean isElegibleNationality = candidate.getNationality().equals(NATIONALITY);
        boolean isElegibleToVote = candidate.isAllowedToVote();
        return isElegibleAgeToVote && isElegibleNationality
                && isElegibleLiveInUkr && isElegibleToVote;
    }

    public boolean periodLiveInUkr(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]) > LIVE_IN_UKR;
    }
}
