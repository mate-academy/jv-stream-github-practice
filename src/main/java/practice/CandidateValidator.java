package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35
                    && candidate.isAllowedToVote()
                    && candidate.getNationality().equals("Ukrainian")
                    && Integer.parseInt(year[1]) - Integer.parseInt(year[0]) >= 10;
    }
}
