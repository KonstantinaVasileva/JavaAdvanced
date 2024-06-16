package Advanced.DefiningClasses.Exercise.PokemonTrainer_06;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Pokemon>> pokemons = new LinkedHashMap<>();
        while (true) {
            String[] data = scanner.nextLine().split(" ");
            if (data[0].equals("Tournament")) {
                break;
            }
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemons.putIfAbsent(trainerName, new ArrayList<>());
            pokemons.get(trainerName).add(pokemon);
        }

        List<Trainer> trainers = pokemons.entrySet().stream().map(t->new Trainer(t.getKey(), t.getValue())).collect(Collectors.toList());

        while (true){
            String element = scanner.nextLine();
            if (element.equals("End")){
                break;
            }

            for (Trainer trainer : trainers) {
                trainer.commandExecuting(element);
            }

        }
        trainers.stream().sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed())
                .forEach(e-> System.out.println(String.format("%s %s %s", e.getName(), e.getNumberOfBadges(), e.getCollectionOfPokemon().size())));
    }
}
