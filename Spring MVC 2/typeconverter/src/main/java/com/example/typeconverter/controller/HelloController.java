package com.example.typeconverter.controller;

import com.example.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); //문자 타입 조회
        Integer intVlaue = Integer.valueOf(data);  //숫자 타입으로 변경
        System.out.println("intVlaue = " + intVlaue);
        return "ok";
    }

    @GetMapping("/hello-v2") // "10,000" 문자로
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort IP = " + ipPort.getIp());
        System.out.println("ipPort.PORT = " + ipPort.getPort());
        return "ok";
    }
}
