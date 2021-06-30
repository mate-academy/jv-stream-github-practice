package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        candidate.setPeriodsInUkr(String.valueOf(Integer.parseInt(split[1])
                - Integer.parseInt(split[0])));

        return candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && Integer.parseInt(candidate.getPeriodsInUkr()) > 10;
    }
}
