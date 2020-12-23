package hoangytm.restaurant.i18n;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author PhanHoang
 * 2/8/2020
 */
public class UrlLocaleResolver implements LocaleResolver {

    private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // ==> /SomeContextPath/en/...
        // ==> /SomeContextPath/fr/...
        // ==> /SomeContextPath/WEB-INF/pages/...
//        String uri = request.getRequestURI();

//        System.out.println("URI=" + uri);
// lay tu thanh URL
//        String prefixEn = request.getServletContext().getContextPath() + "/en/";
//        String prefixFr = request.getServletContext().getContextPath() + "/fr/";
//        String prefixVi = request.getServletContext().getContextPath() + "/vi/";

        Locale locale = null;
        String uri = request.getHeader("Accept-Language");
        // English
        if (uri.startsWith("En")) {
            locale = Locale.ENGLISH;
        }
        // French
        else if (uri.startsWith("Fr")) {
            locale = Locale.FRANCE;
        }
        // Vietnamese
        else if (uri.startsWith("Vi")) {
            locale = new Locale("vi", "VN");
        }
        if (locale != null) {
            request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
        }
        if (locale == null) {
            locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
            if (locale == null) {
                locale = Locale.ENGLISH;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // Nothing
    }

}
