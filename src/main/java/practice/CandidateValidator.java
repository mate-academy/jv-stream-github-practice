package practice;

public class CandidateValidator {
    private static final int MIN_AGE = 35;
    private static final String ABLE_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_LIVED_IN_UKRAINE = 10;
    private static final int INDEX_FOR_START_OF_PERIOD = 0;
    private static final int INDEX_FOR_END_OF_PERIOD = 1;
    private static final String PERIOD_SEPARATOR = "-";
    public boolean getValidAge(int age){
      if (age >= MIN_AGE){
          return true;
      }
      return false;
  }
  public boolean getAbleToVote(boolean able) {
        if(!able) {
            return false;
        }
        return true;
  }
  public boolean checkNationality(String nationality) {
        if (nationality.equals(ABLE_NATIONALITY)) {
            return true;
        }
        return false;
  }
  public boolean checkLivedYearsInUkraine(String years) {
        String[] arrayOfYear = years.split(PERIOD_SEPARATOR);
        int numberOfYear = Integer.parseInt(String.valueOf(arrayOfYear[INDEX_FOR_END_OF_PERIOD]))
                - Integer.parseInt(String.valueOf(arrayOfYear[INDEX_FOR_START_OF_PERIOD]));
        return numberOfYear >= MINIMUM_YEARS_LIVED_IN_UKRAINE;
  }
}
