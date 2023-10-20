package org.example;

import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieMonster {

    private static List<Cookie> cookies = new ArrayList<>();

    public static List<Cookie> getCookies() {
        return  cookies;
    }

    public static void addCookie(Cookie cookie) {
        cookies.add(cookie);
    }
}
