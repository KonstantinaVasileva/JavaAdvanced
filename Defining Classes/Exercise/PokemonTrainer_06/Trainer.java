package Advanced.DefiningClasses.Exercise.PokemonTrainer_06;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemon;

    public Trainer(String name, List<Pokemon> collectionOfPokemon) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collectionOfPokemon = collectionOfPokemon;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getCollectionOfPokemon() {
        return collectionOfPokemon;
    }

    public void commandExecuting(String element) {
        boolean isExist = false;
        for (Pokemon pokemon : collectionOfPokemon) {
            if (pokemon.getElement().contains(element)) {
                isExist = true;
            }
        }
        if (isExist){
            numberOfBadges ++;
        } else {
            for (int i=0; i< collectionOfPokemon.size(); i++) {
                collectionOfPokemon.get(i).setHealth(collectionOfPokemon.get(i).getHealth() - 10);
                if (collectionOfPokemon.get(i).getHealth()<=0){
                    collectionOfPokemon.remove(i);
                    i--;
                }
            }
        }
    }
}