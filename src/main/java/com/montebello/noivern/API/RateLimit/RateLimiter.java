package com.montebello.noivern.API.RateLimit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface RateLimiter {
    int requests() default 10;
    int timeWindow() default 60;
}
