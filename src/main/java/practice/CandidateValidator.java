package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String DATA_SEPARATOR = "-";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int FIRST_YEAR_INDEX_IN_PERIOD = 0;
    private static final int LAST_YEAR_INDEX_IN_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return isAgeEnough(candidate.getAge())
                && candidate.isAllowedToVote()
                && isAcceptableNationality(candidate.getNationality())
                && isEnoughTimeLived(parseDate(candidate.getPeriodsInUkr()));
    }

    private boolean isAgeEnough(int age) {
        return age >= MINIMAL_AGE;
    }

    private boolean isAcceptableNationality(String nationality) {
        return nationality.equals(REQUIRED_NATIONALITY);
    }

    private int parseDate(String data) {
        String[] separatedDate = data.split(DATA_SEPARATOR);

        return Integer.parseInt(separatedDate[LAST_YEAR_INDEX_IN_PERIOD])
                - Integer.parseInt(separatedDate[FIRST_YEAR_INDEX_IN_PERIOD]);
    }

    private boolean isEnoughTimeLived(int time) {
        return time >= MIN_PERIOD_IN_UKRAINE;
    }
    //write your code here
}
