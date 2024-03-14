package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String ABLE_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_LIVED_IN_UKRAINE = 10;
    private static final int INDEX_FOR_START_OF_PERIOD = 0;
    private static final int INDEX_FOR_END_OF_PERIOD = 1;
    private static final String PERIOD_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return validAge(candidate.getAge())
                && getAbleToVote(candidate.isAllowedToVote())
                && checkNationality(candidate.getNationality())
                && checkLivedYearsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean validAge(int age) {
        return age >= MIN_AGE;
    }

    private boolean getAbleToVote(boolean able) {
        return able;
    }

    private boolean checkNationality(String nationality) {
        return nationality.equals(ABLE_NATIONALITY);
    }

    private boolean checkLivedYearsInUkraine(String years) {
        String[] arrayOfYear = years.split(PERIOD_SEPARATOR);
        int numberOfYear = Integer.parseInt(arrayOfYear[INDEX_FOR_END_OF_PERIOD])
                - Integer.parseInt(arrayOfYear[INDEX_FOR_START_OF_PERIOD]);
        return numberOfYear >= MINIMUM_YEARS_LIVED_IN_UKRAINE;
    }
}
