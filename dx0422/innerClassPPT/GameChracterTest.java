package dx0422.innerClassPPT;

public class GameChracterTest {
    public static void main(String[] args) {
        GameCharacter charac = new GameCharacter();

        charac.add("Sword", 1, 100);
        charac.add("Gun", 2, 50);
        charac.print();
    }
}
