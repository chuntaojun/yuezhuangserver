package com.yueserver.controller;

import com.yueserver.service.AutoCompleteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/search")
public class SearchAutoCompleteController {


    @Autowired
    @Resource(name = "AutoCompleteService")
    private AutoCompleteServiceInterface autoCompleteServiceInterface;

    @ResponseBody
    @RequestMapping(value = "/brdName", method = RequestMethod.POST)
    public HashMap<String, List> SearchAutonCompleteBrdName() {
        return autoCompleteServiceInterface.AutoCompleteBrdName();
    }

    @ResponseBody
    @RequestMapping(value = "/prdName", method = RequestMethod.POST)
    public HashMap<String, List> SearchAutoCompletePrdName() {
        return autoCompleteServiceInterface.AutoCompletePrdName();
    }

}
