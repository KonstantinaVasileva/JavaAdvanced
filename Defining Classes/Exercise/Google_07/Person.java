package Advanced.DefiningClasses.Exercise.Google_07;

import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private Car car;
    private List<Children> children;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public Car getCar() {
        return car;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.name).append(System.lineSeparator());
        output.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            output.append(this.company).append(System.lineSeparator());
        }
        output.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            output.append(this.car).append(System.lineSeparator());
        }
        output.append("Pokemon:").append(System.lineSeparator());
        if (this.pokemons != null) {
            this.pokemons.forEach(p->output.append(p).append(System.lineSeparator()));
        }
        output.append("Parents:").append(System.lineSeparator());
        if (this.parents != null) {
            this.parents.forEach(p->output.append(p).append(System.lineSeparator()));
        }
        output.append("Children:").append(System.lineSeparator());
        if (this.children != null) {
            this.children.forEach(p->output.append(p).append(System.lineSeparator()));
        }
        return String.valueOf(output);
    }
    //    public Person(String name, Company company, List<Pokemon> pokemons, List<Parents> parents, Car car, List<Children> children) {
//        this.name = name;
//        this.company = company;
//        this.pokemons = pokemons;
//        this.parents = parents;
//        this.car = car;
//        this.children = children;
//    }
}
