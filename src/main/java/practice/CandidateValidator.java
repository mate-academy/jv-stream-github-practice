package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int STARTINDEX = 0;
    private static final int ENDINDEX = 1;
    private static final int MINTERM = 10;
    private static final int MINAGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR);
        int startOfPeriod = Integer.parseInt(periods[STARTINDEX]);
        int endOfPeriod = Integer.parseInt(periods[ENDINDEX]);
        int termOfLivingInUkraine = endOfPeriod - startOfPeriod;
        return (candidate.getAge() >= MINAGE) && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && termOfLivingInUkraine >= MINTERM;
    }
}
