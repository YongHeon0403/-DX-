package dx0421.collection;

import java.util.ArrayList;

public class MemberArrayList {
    private ArrayList<Member> arrayList;    // ArrayList 선언

    public MemberArrayList() {
        arrayList = new ArrayList<Member>();    // Member 형으로 선언한 ArrayList 생성
    }

    public void addMember(Member member) {
        arrayList.add(member);
    }

    public boolean removeMember(int memberID) {
        for (int i=0; i<arrayList.size(); i++) {
            Member member = arrayList.get(i);
            int tempId = member.getMemberId();
            if (tempId == memberID) {
                arrayList.remove(i);
                return true;
            }
        }
        System.out.println(memberID + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {
        for (Member member : arrayList) {
            System.out.println(member);
        }
        System.out.println( );
    }
}
