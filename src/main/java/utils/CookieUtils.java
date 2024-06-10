package utils;

import java.util.Base64;
import java.util.Hashtable;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class CookieUtils {
	
    // Mã hóa đối tượng generic thành chuỗi Base64
    public static <T> String encodeObjectToBase64(T object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return Base64.getEncoder().encodeToString(json.getBytes());
    }
    
    public static <T> T decodeBase64ToObject(String base64, Class<T> clazz) {
        Gson gson = new Gson();
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        String json = new String(decodedBytes);
        return gson.fromJson(json, clazz);
    }
    
    public static void deleteCookieByName(HttpServletResponse response, String cookie) {
		Cookie cookieCart = new Cookie(cookie, "");
		cookieCart.setMaxAge(0);
	    response.addCookie(cookieCart);
    }
    
    public static String getCookieByName(HttpServletRequest request, String cookie) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookie)) {
                	return c.getValue();
                }
            } 
        }
		return null;
    }
    
    public static void addCookie(HttpServletResponse response, String key, String value) {
    	Cookie u = new Cookie(key, value);
		u.setMaxAge(3600);
		response.addCookie(u);
    }
    
    public static void updateCookieByName(HttpServletRequest request, HttpServletResponse response, String cookie, String value) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookie)) {
                	c.setValue(value);
                	response.addCookie(c);
                	break;
                }
            } 
        }
    }
    
    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Sinh số ngẫu nhiên từ 0 đến 9
            sb.append(digit);
        }

        return sb.toString();
    }
    
    
}
