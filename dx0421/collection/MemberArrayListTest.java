package dx0421.collection;

public class MemberArrayListTest {
    public static void main(String[] args) {
        MemberArrayList memberArrayList = new MemberArrayList();

        Member memberLee = new Member(1001, "이지원");
        Member memberSon = new Member(1002, "손민국");
        Member memberPark = new Member(1003, "박서훤");
        Member memberHong = new Member(1004, "홍길동");

        memberArrayList.addMember(memberLee);
        memberArrayList.addMember(memberSon);
        memberArrayList.addMember(memberPark);
        memberArrayList.addMember(memberHong);

        memberArrayList.showAllMember();

        memberArrayList.removeMember(memberHong.getMemberId());   // 홍길동 회원 삭제
        memberArrayList.showAllMember();
    }
}
