package practice;

import model.Person;

class PersonForWork {
    public boolean check(Person person, int fromAge, int maleToAge, int femaleToAge) {
        return (person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= maleToAge)
                ||
                (person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= fromAge
                && person.getAge() <= femaleToAge);
    }
}
