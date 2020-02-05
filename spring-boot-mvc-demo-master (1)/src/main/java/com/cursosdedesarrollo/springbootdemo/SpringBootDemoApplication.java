package com.cursosdedesarrollo.springbootdemo;

import com.cursosdedesarrollo.springbootdemo.pokemon.Pokemon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cursosdedesarrollo.springbootdemo.pokemon.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PokemonRepository repository) {
        return (args) -> {
            repository.deleteAll();


            repository.save(new Pokemon("Charizard", "Fuego"));
            repository.save(new Pokemon("Pikachu", "Electrico"));

            // fetch all customers
            System.out.println("Pokemons found with findAll():");
            System.out.println("-------------------------------");
            for (Pokemon pokemon : repository.findAll()) {
                System.out.println(pokemon);
            }
            System.out.println();
            // fetch an individual customer
            System.out.println("Customer found with findByname('Pikachu'):");
            System.out.println("--------------------------------");
            System.out.println(repository.findByname("Pikachu"));

            System.out.println("Customers found with findBytype('Electrico'):");
            System.out.println("--------------------------------");
            for (Pokemon pokemon : repository.findBytype("Electrico")) {
                System.out.println(pokemon);
            }

            /*Book b= new Book();
            String autor1="Terry Prattchet";
            String autor2="Neil Gayman";
            List<String> autores=new ArrayList<>();
            autores.add(autor1);
            autores.add(autor2);
            b.setAuthorNames(autores);
            b.setTitle("Buenos Presagios");
            bookRepository.save(b);

            // fetch all customers
            System.out.println("Books found with findAll():");
            System.out.println("-------------------------------");
            for (Book book : bookRepository.findAll()) {
                System.out.println(book);
            }
            System.out.println();
            // fetch an individual book
            System.out.println("Book found with findByTitleContainingOrderByTitle('buenos'):");
            System.out.println("--------------------------------");
            System.out.println(bookRepository.findByTitleContainingOrderByTitle("Buenos"));

            System.out.println("Book found with findByTitle('Buenos'):");
            System.out.println("--------------------------------");
            for (Book book : bookRepository.findByTitleContaining("Buenos")) {
                System.out.println(book);
            }*/


            /*personRepository.deleteAll();

            final Address address =
                    new Address(
                            "19 Imaginary Road",
                            "Imaginary Place",
                            "Imaginary City",
                            "UK");
             */
           /* Address address1=new Address();

            address1.setCountry("UK");
            address1.setAddressLineOne("19 Imaginary Road");
            address1.setAddressLineTwo("Imaginary Place");
            address1.setCity("Imaginary City");

            final Hobby badminton = new Hobby("Badminton");
            final Hobby tv = new Hobby("TV");
            final List<Hobby> hobbies = Arrays.asList(badminton, tv);

            final Person john = new Person(
                    "John",
                    "Doe",
                    LocalDateTime.now(),
                    address1,
                    "Winner",
                    100,
                    hobbies);
            personRepository.save(john);

            System.out.println("Find by first name");
            personRepository.findByFirstName("John").forEach(System.out::println);

            System.out.println("Find by country (UK)");
            personRepository.findByCountry("UK").forEach(System.out::println);

            address1.setCountry("US");
            personRepository.save(john);
            System.out.println("Find by country (US)");
            personRepository.findByCountry("US").forEach(System.out::println);

            System.out.println("Find by hobby (TV)");
            personRepository.findByHobby("TV").forEach(System.out::println);
        };*/

        };
    }
}
