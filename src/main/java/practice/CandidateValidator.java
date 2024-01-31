package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getIntPeriodInUkr(candidate.getPeriodsInUkr()) >= 10;
    }

    //Only for String type like: "2002-2015"
    public int getIntPeriodInUkr(String periodInUkr) {
        String[] period = periodInUkr.split("-");
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}
