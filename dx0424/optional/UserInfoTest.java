package dx0424.optional;

import java.util.ArrayList;

public class UserInfoTest {
    public static void main(String[] args) {
        ArrayList<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(12345, "James"));
        userInfoList.add(new UserInfo(12346, "Tomas"));
        userInfoList.add(new UserInfo(12347, "Edward"));

        UserInfo userInfo = getUserInfoById(12348, userInfoList);
        if (userInfo != null)
            System.out.println(userInfo.getName());
        else
            System.out.println("없는 ID입니다.");
    }

    public static UserInfo getUserInfoById(int id, ArrayList<UserInfo> list) {
        for (UserInfo userInfo : list) {
            if (id == userInfo.getId())
                return userInfo;
        }
        return null;
    }
}
