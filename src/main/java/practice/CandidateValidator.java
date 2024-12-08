package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        boolean oldEnough = candidate.getAge() >= 35;
        boolean nationality = candidate.getNationality().equals("Ukrainian");
        boolean canVote = candidate.isAllowedToVote();
        String[] ages = candidate.getPeriodsInUkr().split("-");
        boolean liveEnoughInUkraine = Integer.parseInt(ages[1])
                - Integer.parseInt(ages[0]) >= 10;

        return oldEnough && nationality && canVote && liveEnoughInUkraine;
    }
}
