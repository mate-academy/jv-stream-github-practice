package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] ints = candidate.getPeriodsInUkr().split("-");
        int firstYear = Integer.parseInt(ints[0]);
        int secondYear = Integer.parseInt(ints[1]);
        int result = secondYear - firstYear;
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && result >= 10;
    }
}
