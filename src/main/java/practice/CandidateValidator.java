package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("[^\\d]");
        boolean isLivedInUkraine = (Integer.parseInt(period[1]) - Integer.parseInt(period[0])) > 10;
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && isLivedInUkraine;
    }
}
