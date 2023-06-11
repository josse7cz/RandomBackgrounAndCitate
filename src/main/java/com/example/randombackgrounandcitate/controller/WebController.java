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
    private DataReader dataReader;

    public WebController() {
        this.random = new Random();
    }
//    @RequestMapping(value = "/index2")
//    public String index() {
//        return "index2";
//    }

    @RequestMapping(value = "/index")
    public ModelAndView index() throws IOException {
//        List<String> list=new ArrayList<String>();
//        list= dataReader.readAllLines("/data/citaty.txt");
        ModelAndView result = new ModelAndView("index");

        List<String> quoteItem = new ArrayList<String>();
        quoteItem.add("\"Nejsmutnější žena je ta, která má v sobě něco z víly a něco z ženy.\" - Karel Čapek");
        quoteItem.add("\"Když se člověk narodí, dostane pytlík štěstí. Největší to však je, když potká člověka, kterému může štěstí rozdávat.\" - Jan Werich");
        quoteItem.add("\"Věřte v lásku, ale nezoufejte, když nepřijde. Láska přichází, když to nejméně čekáte.\" - Milan Kundera");
        quoteItem.add("\"Člověk nemůže dostatečně zdůraznit, jakou významnou roli hrají knihy v jeho životě. Jsou nám průvodci, dozorci, přátelé.\" - Bohumil Hrabal");
        quoteItem.add("\"Věřím, že život má smysl a že náš každodenní život má něco vznešeného a jedinečného.\" - Václav Havel");
        result.addObject("citat", quoteItem.get(random.nextInt(5)));
        return result;
    }
}
