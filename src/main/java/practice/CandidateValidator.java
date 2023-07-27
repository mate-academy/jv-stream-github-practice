package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] datesOfLiving = candidate.getPeriodsInUkr().split("-");
        int periodOfLiving =
                Integer.parseInt(datesOfLiving[1]) - Integer.parseInt(datesOfLiving[0]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodOfLiving >= 10;
    }
}
