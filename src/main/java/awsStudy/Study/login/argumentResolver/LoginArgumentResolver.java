package awsStudy.Study.login.argumentResolver;

import awsStudy.Study.login.SessionConst;
import awsStudy.Study.login.session.SessionDto;
import awsStudy.Study.member.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Login.class) &&
                (Member.class.isAssignableFrom(parameter.getParameterType()) ||
                        SessionDto.class.isAssignableFrom(parameter.getParameterType()));
    }

    //    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//
//        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
//        HttpSession session = request.getSession(false);
//
//        if (session == null) {
//            return null;
//        }
//        return session.getAttribute(SessionConst.LOGIN_SESSION);
//    }
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        HttpSession session = request.getSession(false);

        if (session == null) {
            System.out.println("[resolver] 세션이 없습니다.");
            return null;
        }

        Object sessionValue = session.getAttribute(SessionConst.LOGIN_SESSION);

        if (sessionValue == null) {
            System.out.println("[resolver] 세션에서 아무것도 꺼내지 못했습니다.");
            return null;
        }

        System.out.println("[resolver] 세션에서 꺼낸 객체 타입: " + sessionValue.getClass().getName());
        System.out.println("[resolver] 세션에서 꺼낸 객체 내용: " + sessionValue);

        return sessionValue;
    }


}
