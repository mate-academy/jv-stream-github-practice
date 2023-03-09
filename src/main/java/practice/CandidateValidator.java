package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEAR_SPLITTER = "-";
    private static final int FIRST_ARRAY_ELEMENT = 0;
    private static final int SECOND_ARRAY_ELEMENT = 1;
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_YEAR_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split(YEAR_SPLITTER);
        int yearInUkr = Integer.parseInt(year[SECOND_ARRAY_ELEMENT])
                                            - Integer.parseInt(year[FIRST_ARRAY_ELEMENT]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals("Ukrainian")
                && yearInUkr >= MINIMUM_YEAR_IN_UKR;
    }
}
