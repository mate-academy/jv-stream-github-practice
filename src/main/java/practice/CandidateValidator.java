package practice;

import model.Candidate;
import model.Person;

public class CandidateValidator {
    //write your code here
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "ukrainian";
    private static final int LIVED_TEN_YEARS = 10;

    public boolean isHeHaveEnoughYears(Candidate candidate) {
        return candidate.getAge() > MINIMAL_AGE;
    }

    public boolean isHeHaveCorrectNationality(Candidate candidate) {
        return candidate.getNationality().toLowerCase()
                .equals(NATIONALITY);
    }

    public boolean isHeLivedInCountryEnough(Candidate candidate) {
        int from = 0;
        int to = 1;
        String[] splitPeriods = candidate.getPeriodsInUkr().split("-");
        int livedInCountry = Integer.parseInt(splitPeriods[1]) - Integer.parseInt(splitPeriods[0]);
        return livedInCountry >= LIVED_TEN_YEARS;
    }
}
