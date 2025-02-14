package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    public static final int MIN_AGE = 35;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int RESIDENCE_DURATION = 10;
    public static final String PERIOD_DELIMITATION = "-";

    @Override
    public boolean test(Candidate candidate) {
        try {
            String[] periodYears = candidate.getPeriodsInUkr().split(PERIOD_DELIMITATION);
            int startYear = Integer.parseInt(periodYears[0]);
            int endYear = Integer.parseInt(periodYears[1]);
            if (periodYears.length != 2) {
                throw new RuntimeException("Invalid period in " + candidate.getPeriodsInUkr()
                        + " Only \"YYYY-YYYY\" format is accepted");
            }
            if (startYear > endYear) {
                throw new RuntimeException("The date data is invalid: first field has to be the"
                        + "start of residence and the second one of finishing it.");
            }
            return candidate.getAge() >= MIN_AGE
                    && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                    && candidate.isAllowedToVote()
                    && Integer.parseInt(periodYears[1]) - Integer.parseInt(periodYears[0])
                    >= RESIDENCE_DURATION;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
