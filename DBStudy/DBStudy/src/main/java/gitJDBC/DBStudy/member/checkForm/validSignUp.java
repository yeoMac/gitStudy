package gitJDBC.DBStudy.member.checkForm;

import gitJDBC.DBStudy.member.repository.MemberRepository;

public class validSignUp {

    private final MemberRepository memberRepository;

    public validSignUp(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private String validEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private String validPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public void validEmail(String email) {
        if (email == null || !email.matches(validEmail)) {
            throw new IllegalStateException("등록된 이메일입니다.");
        }
    }

    public void validPassword(String password) {
        if (password == null || password.length() < 8 || !password.matches(validPassword)) {
            throw new IllegalStateException("비밀번호를 확인해주세요.");
        }
    }
}
