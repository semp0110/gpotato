package com.gpotato.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hirang on 2017-08-14.
 */
@RestController
public class HellowController
{
    @RequestMapping("/")
    public String index() {return "잘살아보세!~";}
}
