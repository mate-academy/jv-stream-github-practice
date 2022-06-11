package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        int periodInUkraine;
        int periodFrom = 0;
        int periodTo = 1;
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        periodInUkraine = Integer.parseInt(periodsInUkr[periodTo])
                - Integer.parseInt(periodsInUkr[periodFrom]);
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase("ukrainian")
                && periodInUkraine > 10;
    }
}
