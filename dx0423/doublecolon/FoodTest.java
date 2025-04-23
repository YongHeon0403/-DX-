package dx0423.doublecolon;

import java.util.function.Function;

public class FoodTest {
    public static void main(String[] args) {

        Function<String, Food> function1 = (String a) -> new Food(a);
        Food food = function1.apply("pizza");
        System.out.println(food.getName());

        Function<String, Food> function2 = Food::new;
        food = function2.apply("pasta");
        System.out.println(food.getName());

    }
}
