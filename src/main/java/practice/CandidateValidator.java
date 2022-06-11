package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriods = candidate.getPeriodsInUkr().split("-");
        int howLongLive = Integer.parseInt(splitPeriods[0]) - Integer.parseInt(splitPeriods[1]);
        boolean isLivingMoreThanTenYears = howLongLive >= 10;

        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isLivingMoreThanTenYears;
    }
}
