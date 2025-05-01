package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVE_AGE = 10;
    private static final String COUNTRY = "Ukrainian";
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase(COUNTRY)
                && checkYear(candidate);
    }

    private boolean checkYear(Candidate candidate) {
        String yearStr = candidate.getPeriodsInUkr();
        int indexOfDash = yearStr.indexOf(DASH);

        if (indexOfDash == -1) {
            throw new IllegalArgumentException("Invalid input format. The input string "
                    + "must contain a '-' character.");
        }

        String year1 = yearStr.substring(0, indexOfDash);
        String year2 = yearStr.substring(indexOfDash + 1);

        int liveAge = Integer.parseInt(year2) - Integer.parseInt(year1);

        return liveAge >= MIN_LIVE_AGE;
    }
}
