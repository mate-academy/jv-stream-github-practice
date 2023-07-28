package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && isLongTimePeriod(candidate.getPeriodsInUkr());
    }

    private boolean isLongTimePeriod(String prePeriod) {
        String[] periodInUkr = prePeriod.split("-");
        int countYearInUkr = Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0]);
        if (countYearInUkr >= 10) {
            return true;
        }
        return false;
    }
}
