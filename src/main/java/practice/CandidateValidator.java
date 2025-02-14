package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int RESIDENCE_DURATION = 10;
    private static final String PERIOD_DELIMITATION = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodYears = candidate.getPeriodsInUkr().split(PERIOD_DELIMITATION);
        int startYear;
        int endYear;
        try {
            startYear = Integer.parseInt(periodYears[0]);
            endYear = Integer.parseInt(periodYears[1]);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        if (periodYears.length != 2) {
            throw new RuntimeException("Invalid period in " + candidate.getPeriodsInUkr()
                    + " Only \"YYYY-YYYY\" format is accepted");
        }
        if (startYear > endYear) {
            throw new RuntimeException("The date data is invalid: first field has to be the"
                    + "start of residence and the second one of finishing it.");
        }
        /*I`m not sure that understood admonition about this method well.
        * I've transferred period conditions out of try block and
        * left only parseInt() methods there. Check if i did wright.
        * But what did ou mean about using Predicate for complicated conditions
        * in return statement? This method is overriden Predicate's test method
        * as the class implements it. So I have included complicated checkup here...
        * Other way i will use Predicate for Predicate.*/
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && Integer.parseInt(periodYears[1]) - Integer.parseInt(periodYears[0])
                >= RESIDENCE_DURATION;
    }
}
