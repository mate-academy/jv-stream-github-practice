package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_YEAR_OLD = 35;
    public static final int MIN_YEAR_LIVE = 10;
    public static final int POS_YEAR_FROM = 0;
    public static final int POS_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return "Ukrainian".equals(candidate.getNationality())
                && candidate.getAge() >= MIN_YEAR_OLD
                && candidate.isAllowedToVote()
                && candidate.getPeriodsInUkr() != null
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[POS_YEAR_TO])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[POS_YEAR_FROM])
                >= MIN_YEAR_LIVE;
    }
}
