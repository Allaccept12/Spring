package hello.core.web;


import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    //HttpServletRequest 를받으면 고객 요청 정보를 받을수있음
    public String logDemo(HttpServletRequest request){

        String requestURL = request
                .getRequestURL()
                .toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.losic("testId");
        return "OK";
    }



}
