package com.yicj.study.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            Map<String, String> headers = this.getHeaders();
            for(String headerName : headers.keySet()){
                // 跳过 content-length
                if (!"content-length".equalsIgnoreCase(headerName)){
                    requestTemplate.header(headerName, headers.get(headerName));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Map<String, String> getHeaders(){
        // 线程缓存中没有，则从request头中取
        return FeignBasicAuthRequestInterceptor.getHeadersMap();
    }

    /**
     * 此方法父线程有可能调用，提前拿出父线程request的请求头信息
     * @return
     */
    public static Map<String, String> getHeadersMap(){
        Map<String, String> map = new LinkedHashMap<>();
        ServletRequestAttributes requestAttr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(null != requestAttr){
            HttpServletRequest request = requestAttr.getRequest();
            Enumeration<String> enumeration = request.getHeaderNames();
            while (enumeration.hasMoreElements()) {
                String key = enumeration.nextElement();
                String value = request.getHeader(key);
                map.put(key, value);
            }
        }
        return map;
    }

}
