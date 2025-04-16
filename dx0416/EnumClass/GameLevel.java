package dx0416.EnumClass;

public enum GameLevel {
    BEGINNER_LEVEL(1, "초보자"),
    ADVANCED_LEVEL(2, "숙련자"),
    SUPER_LEVEL(3, "고수");

    private int level;      // 상수가 가질 수 있는 속성을
    private String hint;    // 인스턴스 변수로 선언

    GameLevel(int level, String hint) {
        this.level = level;     // 각 상수의
        this.hint = hint;       // 속성을 초기화
    }

    public int getLevel() {
        return level;
    }
    public String getHint() {
        return hint;
    }
/*  values() 메서드 사용 - enum 에 선언한 모든 상수를 하나의 배열롤 반환할 수 있다.
    public static void main(String[] args) {
        GameLevel[] gameLevels = GameLevel.values();
        for (GameLevel level : gameLevels) {
            System.out.println(level);
        }
    }  enum 의 values() 메서드를 사용하면 상수를 배열로 반환받을 수 있다. */

/*  toString() 메서드 사용 - 상수가 아닌 다른 속성값이 보여지길 원한다면 toString() 메서드를 재정의할 수 있다.
    public String toString() {
        return getHint();
    }
    public static void main(String[] args) {
    }  toString() 메서드를 재정의해 hint 값이 반환되도록 구현했다. */

    /* valueOf() 메서드는 enum 에 해당하는 상수가 있는지 확인하고, 해당하는 상수가 있다면 인스턴스를 반환한다. */
        public static void main(String[] args) {
    /*        GameLevel[] gameLevels = GameLevel.values();
    //        for (GameLevel level : gameLevels) {
    //            System.out.println(level);
            } */
        GameLevel gameLevel = GameLevel.valueOf("BEGINNER_LEVEL");
        System.out.println(gameLevel.getLevel());
        System.out.println(gameLevel.getHint());
    } // valueOf() 메서드를 활용해 GameLevel 의 BEGINNER_LEVEL 상수를 반환받아 메서드를 호출해 속성값을 사용한다.
}