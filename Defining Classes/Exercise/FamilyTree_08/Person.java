package Advanced.DefiningClasses.Exercise.FamilyTree_08;

import Advanced.DefiningClasses.Exercise.Google_07.Children;

import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> child;
    private List<Person> parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Person> getChild() {
        return child;
    }

    public void setChild(List<Person> child) {
        this.child = child;
    }

    public List<Person> getParent() {
        return parent;
    }

    public void setParent(List<Person> parent) {
        this.parent = parent;
    }
    public void addChild(Person child){
        this.child.add(child);
    }
}
