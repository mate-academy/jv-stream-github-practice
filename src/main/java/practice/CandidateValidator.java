package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodInUkraineStart = Integer.parseInt(periodInUkraine[0]);
        int periodInUkraineFinish = Integer.parseInt(periodInUkraine[1]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraineFinish - periodInUkraineStart > 10;
    }
}
