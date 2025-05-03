package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int VOTE_AGE = 35;
    private static final int YEARS = 10;
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VOTE_AGE && candidate.isAllowedToVote()
                && checkDate(candidate.getPeriodsInUkr())
                && candidate.getNationality().equals(NATIONALITY);
    }

    private boolean checkDate(String getPeriodsInUkr) {
        String[] arrayData = getPeriodsInUkr.split(SEPARATOR);
        int result = Integer.parseInt(String.valueOf(arrayData[SECOND_INDEX]))
                - Integer.parseInt(String.valueOf(arrayData[FIRST_INDEX]));
        return result >= YEARS;
    }
}
