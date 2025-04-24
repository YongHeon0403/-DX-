package dx0424.optional;

import java.util.ArrayList;
import java.util.Optional;

public class UserInfoTestUsingOptional {
    public static void main(String[] args) {
        ArrayList<UserInfo> userInfoList = new ArrayList<>();

        userInfoList.add(new UserInfo(12345, "James"));
        userInfoList.add(new UserInfo(12346, "Tomas"));
        userInfoList.add(new UserInfo(12347, "Adward"));

        usingOptional(userInfoList);

        String str = "abc";
        Optional<String> optVal = Optional.of(str);
        String str1 = optVal.get();
        System.out.println(str1);

        Optional<String> optVal2 = Optional.of("abc");
        Optional<String> optVal3 = Optional.of(new String("abc"));

//        Optional<String> optVal4 = null;    // 널로 초기화 (쓰이진 않는다.)
        Optional<String> optVal5 = Optional.empty();    // 널로 초기화 2
    }

    public static void usingOptional(ArrayList<UserInfo> list) {
        // ArrayList 에서 아이디로 사용자를 찾아옴. 반환값이 Optional 클래스
        Optional<UserInfo> userInfoOptional = getUserInfoByIdOptional(12348, list);

        // ifPresent() : 값이 존재할 때만 주어진 작업을 실행하는 메서드
        // ifPresent()메서드를 사용하여 값이 존재하는 경우에만 출력
        userInfoOptional.ifPresent(userInfo -> System.out.println("User name found: + " +
                userInfo.getName()));

        // isPresent() : Optional 객체에 값이 있는지 여부를 판단하는 메서드. 있으면 true 없으면 false
        // isPresent()메서드를 사용하여 조건문 처리
        if (userInfoOptional.isPresent()) {
            System.out.println("User name found: " + userInfoOptional.get().getName());
        }
        else
            System.out.println("User not found");

        // orElse() : Optional 객체의 값이 없을 때, 파라미터로 넘어온 값을 반환하는 메서드
        // orElse()메서드를 사용하여 값이 없는 경우 기본값을 생성
        UserInfo nameOrDefault = userInfoOptional.orElse(new UserInfo(00000, "Guest"));
        System.out.println("User name: " + nameOrDefault.getName());

        // orElseGet()메서드를 사용하여 기본값을 람다식 처리
        UserInfo nameOrComputed = userInfoOptional.orElseGet(() -> generateDafaultUserInfo());
        System.out.println("User name: " + nameOrComputed.getName());

        // try, catch : 오류가 발생할 가능성이 있는 코드를 시도해보고, 오류가 발생하면 처리하는 구문
        // orElseThrow()메서드를 사용하여 값이 없을 때 예외 처리
        try {
            UserInfo userNotFound = userInfoOptional.orElseThrow(() ->
                    new IllegalStateException("User not found"));
            System.out.println("User name: " + userNotFound.getName());
        } catch(IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Optional<UserInfo> getUserInfoByIdOptional
            (int id, ArrayList<UserInfo> list) {
        for (UserInfo userInfo : list) {
            if (id == userInfo.getId())
                return Optional.of(userInfo);
        }
        return Optional.empty();    // 값을 갖지 않는 빈(empty) Optional 객체를 생성하는 메서드
}

    public static UserInfo generateDafaultUserInfo() {
        return new UserInfo(00000, "Guest");
    }
}