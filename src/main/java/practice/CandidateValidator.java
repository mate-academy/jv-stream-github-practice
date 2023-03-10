package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIODS_IN_UKR = 10;
    private static final int FIRST_DATE_INDEX = 0;
    private static final int SECOND_DATE_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = (candidate.getPeriodsInUkr().split("-"));
        int firstDate = Integer.parseInt(years[FIRST_DATE_INDEX]);
        int secondDate = Integer.parseInt(years[SECOND_DATE_INDEX]);

        return (candidate.getAge() >= MIN_AGE)
                && (candidate.isAllowedToVote())
                && (candidate.getNationality().equals(NATIONALITY))
                && (secondDate - firstDate > MIN_PERIODS_IN_UKR);

    }

}
