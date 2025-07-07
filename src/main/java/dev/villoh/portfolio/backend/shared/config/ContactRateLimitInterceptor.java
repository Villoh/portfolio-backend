package dev.villoh.portfolio.backend.shared.config;

import com.github.benmanes.caffeine.cache.Cache;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ContactRateLimitInterceptor implements HandlerInterceptor {
    private final Cache<String, Integer> contactRateLimitCache;

    public ContactRateLimitInterceptor(Cache<String, Integer> contactRateLimitCache) {
        this.contactRateLimitCache = contactRateLimitCache;
    }

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        if (request.getRequestURI().equals("/api/contact") && request.getMethod().equalsIgnoreCase("POST")) {
            String ip = getClientIp(request);
            Integer count = contactRateLimitCache.getIfPresent(ip);
            if (count == null) count = 0;
            if (count >= 2) {
                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                response.getWriter().write("Rate limit exceeded: Only 2 contact requests per hour allowed.");
                return false;
            }
            contactRateLimitCache.put(ip, count + 1);
        }
        return true;
    }

    private String getClientIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}

