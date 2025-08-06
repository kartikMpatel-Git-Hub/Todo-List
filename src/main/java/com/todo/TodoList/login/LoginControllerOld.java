package com.todo.TodoList.login;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/*
* RequestMapping : endpoint (value = <endpoin>,method=<method type (GET,POST...)>)
* RequestBody : to Show As it is Data Which Return From Function
* RequestParams : get Parameter From URL As Well As POST method's Form
* ModeMap : pass The Data To JSP
* Logger : show Message On Console Based On Level (like. info,debug..)
* SessionAttributes : Get That Data In All Page Where It Define
* */

@Controller
@SessionAttributes("name")
public class LoginControllerOld {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired // -> Another Way To Autowire
    private AuthenticationService authenticationService;

    public LoginControllerOld(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping("loginTest")
    public String loginPageTest(@RequestParam String name, @RequestParam Integer age, ModelMap modelMap){
        modelMap.put("name",name);
        modelMap.put("age",age);
        logger.debug("Name : {}", name);
        logger.debug("Age : {}", age);
//        System.out.println("Request Param Name Is : " + name);
//        System.out.println("Request Param Age Is : " + age);
        return "loginTest";
    }

//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String loginPage(){
//        return "welcome";
//    }

//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String landingPage(ModelMap modelMap){
//        modelMap.put("name","test user");
//        return "welcome";
//    }

//    @RequestMapping(value = "/",method = RequestMethod.POST)
//    public String indexPage(@RequestParam String name,
//                            @RequestParam String password,
//                            ModelMap modelMap){
//        modelMap.put("name",name);
//        if(authenticationService.authenticate(name,password)){
//            return "welcome";
//        }
//        modelMap.put("error","Invalid Authentication !");
//        return "login";
//    }

//    @RequestMapping(value = "login",method = RequestMethod.POST)
//    public String gotoWelcomePage(@RequestParam String name,
//                                  @RequestParam String password,
//                                  ModelMap modelMap){
//        modelMap.put("name",name);
//        /*
//         * Authentication
//         * name : kartik
//         * password : 123
//         *
//         * else login Again
//         *
//         * */
//        if(authenticationService.authenticate(name,password)){
//            return "welcome";
//        }
//        modelMap.put("error","Invalid Authentication !");
//        return "login";
//    }

}
