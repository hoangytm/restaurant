package hoangytm.restaurant.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author PhanHoang
 * 2/8/2020
 */
@Component
public class Translator {

    @Autowired
    private ApplicationContext context;

    public String toLocale(String messageCode){
        MessageSource messageSource= context.getBean(MessageSource.class);

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(messageCode,null, locale);

    }

}
