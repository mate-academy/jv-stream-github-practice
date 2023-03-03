package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        int periodInUkraineFrom
                = Integer.parseInt(candidate
                .getPeriodsInUkr()
                        .substring(candidate.getPeriodsInUkr().indexOf("-") + 1));
        int periodInUkraineTo
                = Integer.parseInt(candidate
                .getPeriodsInUkr()
                        .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraineFrom
                - periodInUkraineTo
                >= 10;
    }
}
