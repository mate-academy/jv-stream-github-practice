package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        int minValidAge = 35;
        int minValidYearsLiveInUkraine = 10;
        int firstPosInLivePeriod = 0;
        int secondPosInLivePeriod = 1;
        return candidate.getAge() >= minValidAge
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[secondPosInLivePeriod])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[firstPosInLivePeriod])
                > minValidYearsLiveInUkraine;
    }
}
