package com.example.randombackgrounandcitate.controller;

import com.example.randombackgrounandcitate.DataReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class WebController {
    private final Random random;
    final String FILE_NAME = "fileToCreate.txt";
    private final DataReader dataReader = new DataReader();

    public WebController() {
        this.random = new Random();
    }

    @RequestMapping(value = "/index")
    public ModelAndView index() throws IOException {
        List<String> list = new ArrayList<String>();
        list = dataReader.readByJava8("citaty.txt");
        ModelAndView result = new ModelAndView("index");
        result.addObject("citate", list.get(random.nextInt(5)));
        return result;
    }

    @RequestMapping("/read")
    public ModelAndView read() throws IOException {
        List<String> list;
        list = dataReader.readByJavaClassic("citaty.txt");
        ModelAndView result = new ModelAndView("read");
        result.addObject("reader", list.get(random.nextInt(5)));
        return result;
    }
}
