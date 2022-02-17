package com.greenfoxacademy.normalexam;

import com.greenfoxacademy.normalexam.models.Meal;
import com.greenfoxacademy.normalexam.models.Type;
import com.greenfoxacademy.normalexam.models.User;
import com.greenfoxacademy.normalexam.repositories.MealRepository;
import com.greenfoxacademy.normalexam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.greenfoxacademy.normalexam.models.Type.*;

@SpringBootApplication
public class NormalExamApplication implements CommandLineRunner {
    private MealRepository mealRepository;
    private UserRepository userRepository;

    @Autowired
    public NormalExamApplication(MealRepository mealRepository, UserRepository userRepository) {
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(com.greenfoxacademy.normalexam.NormalExamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(1L, "PalkoR", "pavelko@gmail.com", "tajomstvo"));
        userRepository.save(new User(2L, "miskoMasterChef", "michal.brblavy@zoznam.sk", "sekret"));
        userRepository.save(new User(3L, "BarbaraMCD", "barbara@mcdonaldova.com", "halabala"));
        userRepository.save(new User(4L, "JOGIIN", "joyinzbayin@baziny.sk", "zabudolsom"));

        mealRepository.save(new Meal(1L, "Mashed potatoes", MAIN_COURSE, userRepository.findById(1L).get()));
        mealRepository.save(new Meal(2L, "Hot dog", APPETIZER, userRepository.findById(4L).get()));
        mealRepository.save(new Meal(3L, "Fries with Hamburger", MAIN_COURSE, userRepository.findById(1L).get()));
        mealRepository.save(new Meal(4L, "Lentil soup", SOUP, userRepository.findById(1L).get()));
        mealRepository.save(new Meal(5L, "Cabbage Soup", SOUP, userRepository.findById(2L).get()));
        mealRepository.save(new Meal(6L, "Mushroom risotto with cheese", APPETIZER, userRepository.findById(3L).get()));
        mealRepository.save(new Meal(7L, "Chocolate LavaCake", DESSERT, userRepository.findById(2L).get()));
        mealRepository.save(new Meal(8L, "Chicken Pho", SOUP, userRepository.findById(1L).get()));
        mealRepository.save(new Meal(9L, "Sushi", APPETIZER, userRepository.findById(4L).get()));
        mealRepository.save(new Meal(10L, "Wiener schnitzel", MAIN_COURSE, userRepository.findById(3L).get()));
        mealRepository.save(new Meal(11L, "Tiramisu", DESSERT, userRepository.findById(4L).get()));
        mealRepository.save(new Meal(12L, "Strawberry CheeseCake", DESSERT, userRepository.findById(3L).get()));
        mealRepository.save(new Meal(13L, "Apple pie", DESSERT, userRepository.findById(2L).get()));
        mealRepository.save(new Meal(14L, "Soy beans soup with tofu", SOUP, userRepository.findById(1L).get()));
        mealRepository.save(new Meal(15L, "Toast with tar-tar", APPETIZER, userRepository.findById(4L).get()));
        mealRepository.save(new Meal(16L, "Grilled cheese with french fries", MAIN_COURSE, userRepository.findById(2L).get()));
        mealRepository.save(new Meal(17L, "Caesar salad with balsamico and olive oil", MAIN_COURSE, userRepository.findById(3L).get()));
        mealRepository.save(new Meal(18L, "Maccaroni & Cheese", MAIN_COURSE, userRepository.findById(4L).get()));
        mealRepository.save(new Meal(19L, "Salmon with the sweet potatoes and steamed broccoli", MAIN_COURSE, userRepository.findById(2L).get()));
    }
}
