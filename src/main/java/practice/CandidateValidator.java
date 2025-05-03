package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_DATE_INDEX = 0;
    private static final int SECOND_DATE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split("-");
        if (Integer.parseInt(dates[SECOND_DATE_INDEX])
                - Integer.parseInt(dates[FIRST_DATE_INDEX]) >= 10) {
            return 35 <= candidate.getAge() && candidate.isAllowedToVote()
                    && candidate.getNationality() != null
                    && candidate.getNationality().equals("Ukrainian");
        }
        return false;
    }
}
