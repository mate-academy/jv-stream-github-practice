package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
     public boolean test(Candidate candidate) {
        if (candidate == null || candidate.getNationality() == null
                                || candidate.getPeriodsInUkr() == null) {
            return false;
        }
        String[] periodInUkraineStrings = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(periodInUkraineStrings[1])
                - Integer.parseInt(periodInUkraineStrings[0]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraine >= 10;
    }
}
