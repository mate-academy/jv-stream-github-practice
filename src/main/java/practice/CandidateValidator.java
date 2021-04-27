package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        int difference = Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0]);

        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && difference >= 10;
    }
}
