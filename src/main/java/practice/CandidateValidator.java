package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        Integer periodStars = Integer.parseInt(period[0]);
        Integer periodFinish = Integer.parseInt(period[1]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodFinish - periodStars >= 10;
    }
}
