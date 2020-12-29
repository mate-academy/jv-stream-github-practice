package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isLivedInUkr10Yeas(candidate.getPeriodsInUkr());
    }

    private boolean isLivedInUkr10Yeas(String getPeriodInUkr) {
        String[] datesInUkr = getPeriodInUkr.split("-");
        return (Integer.valueOf(datesInUkr[1]) - Integer.valueOf(datesInUkr[0])) >= 10;
    }
}
