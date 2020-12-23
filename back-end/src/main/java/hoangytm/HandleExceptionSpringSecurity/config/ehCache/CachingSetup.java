package hoangytm.HandleExceptionSpringSecurity.config.ehCache;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.context.annotation.Configuration;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author PhanHoang
 * 2/9/2020
 */
@Configuration
public class CachingSetup implements JCacheManagerCustomizer {
    @Override
    public void customize(CacheManager cacheManager) {
        cacheManager.createCache("people", new MutableConfiguration<>()
                .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 20)))
                .setStoreByValue(false)
                .setStatisticsEnabled(true));
    }
}
