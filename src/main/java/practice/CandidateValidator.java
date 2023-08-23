package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        boolean isLive10Years = Integer.parseInt(years[1]) - Integer.parseInt(years[0]) > 10;
        if (candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && isLive10Years) {
            return true;
        }
        return false;
    }
}
