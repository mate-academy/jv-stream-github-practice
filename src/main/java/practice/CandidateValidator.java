package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedYears = candidate.getPeriodsInUkr().split("-");
        int[] yearsFromTo = new int[]
                {Integer.parseInt(splitedYears[0]), Integer.parseInt(splitedYears[1])};
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsFromTo[1] - yearsFromTo[0] >= 10;
    }
}
