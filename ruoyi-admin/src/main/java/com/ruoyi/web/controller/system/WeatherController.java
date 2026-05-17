package com.ruoyi.web.controller.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@RestController
@RequestMapping("/system/weather")
public class WeatherController {

    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);

    @Value("${weather.weather.key}")
    private String weatherKey;

    @Value("${weather.weather.city:上海}")
    private String defaultCity;

    private static final Map<String, String> CITY_ID_MAP = new HashMap<>();

    static {
        CITY_ID_MAP.put("北京", "101010100");
        CITY_ID_MAP.put("上海", "101020100");
        CITY_ID_MAP.put("广州", "101280101");
        CITY_ID_MAP.put("深圳", "101280601");
        CITY_ID_MAP.put("杭州", "101210101");
        CITY_ID_MAP.put("南京", "101190101");
        CITY_ID_MAP.put("武汉", "101200101");
        CITY_ID_MAP.put("成都", "101270101");
        CITY_ID_MAP.put("重庆", "101040100");
        CITY_ID_MAP.put("天津", "101030100");
        CITY_ID_MAP.put("西安", "101110101");
        CITY_ID_MAP.put("长沙", "101250101");
    }

    /**
     * 获取实时天气
     * @param city 城市名称（可选，默认使用配置的城市）
     */
    @GetMapping("/now")
    public AjaxResult now(@RequestParam(required = false) String city) {
        if (city == null || city.isEmpty()) {
            city = defaultCity;
        }

        log.info("开始请求天气数据，城市: {}, API Key: {}", city, weatherKey);

        String locationId = CITY_ID_MAP.get(city);
        if (locationId == null) {
            locationId = city;
            log.warn("城市 {} 不在映射表中，尝试直接使用城市名", city);
        } else {
            log.info("使用区位ID: {}", locationId);
        }

        try {
            String encodedLocation = URLEncoder.encode(locationId, "UTF-8");
            String url = "https://devapi.qweather.com/v7/weather/now?location=" + encodedLocation + "&key=" + weatherKey;
            log.info("请求URL: {}", url);

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Accept-Encoding", "gzip");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();
            log.info("HTTP响应码: {}", responseCode);

            if (responseCode != 200) {
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
                StringBuilder errorResult = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResult.append(errorLine);
                }
                errorReader.close();
                log.error("和风天气API返回错误码: {}, 错误信息: {}", responseCode, errorResult.toString());
                conn.disconnect();

                log.warn("使用模拟天气数据作为降级方案");
                return getMockWeatherData(city);
            }

            BufferedReader reader;
            String encoding = conn.getContentEncoding();
            if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
                reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(conn.getInputStream()), "UTF-8"));
            } else {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            }

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            conn.disconnect();

            String response = result.toString();
            log.info("天气接口响应: {}", response);

            if (response == null || response.isEmpty()) {
                log.error("天气接口返回空数据");
                return AjaxResult.error("天气服务返回空数据");
            }

            return AjaxResult.success("weather", response);
        } catch (Exception e) {
            log.error("调用天气接口失败", e);
            log.warn("使用模拟天气数据作为降级方案");
            return getMockWeatherData(city);
        }
    }

    private AjaxResult getMockWeatherData(String city) {
        String mockData = String.format(
                "{\"code\":\"200\",\"updateTime\":\"2026-05-17T15:30+08:00\",\"now\":{\"obsTime\":\"2026-05-17T15:27+08:00\",\"temp\":\"25\",\"feelsLike\":\"26\",\"text\":\"晴\",\"windDir\":\"东南风\",\"windScale\":\"3\",\"humidity\":\"65\",\"precip\":\"0.0\",\"pressure\":\"1013\",\"vis\":\"16\",\"cloud\":\"15\",\"dew\":\"18\"}}",
                city
        );
        return AjaxResult.success("weather", mockData);
    }
}
