package hoangytm.HandleExceptionSpringSecurity.i18n;

import hoangytm.HandleExceptionSpringSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Locale;

/**
 * @author PhanHoang
 * 2/8/2020
 */
public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);

        if (localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        }

        // Lấy ra thông tin Locale từ LocaleResolver URL
        Locale locale = localeResolver.resolveLocale(request);

        localeResolver.setLocale(request, response, locale);

        return true;
    }


}
