package com.bits.bitsDemo.controller;

import com.bits.bitsDemo.common.BaseController;
import com.bits.bitsDemo.services.action.studentinfo.CreateStudentInfoActionService;
import com.bits.bitsDemo.services.action.studentinfo.ListStudentInfoActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by aman.ullah on 2/26/2019.
 */
@Controller
public class StudentController extends BaseController {

    private CreateStudentInfoActionService createStudentInfoActionService;
    private ListStudentInfoActionService listStudentInfoActionService;

    @Autowired
    public StudentController(CreateStudentInfoActionService createStudentInfoActionService
            , ListStudentInfoActionService listStudentInfoActionService) {
        this.createStudentInfoActionService = createStudentInfoActionService;
        this.listStudentInfoActionService = listStudentInfoActionService;
    }


    @GetMapping("/student")
    public String showStudent() {
        return "view/student/show";
    }

    @GetMapping("/studentRestShow")
    public String studentRestShow() {
        return "view/studentrest/show"; // this is to rest UI
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(@RequestParam Map<String, Object> parameters) throws Exception {
        // @RequestParam MultiValueMap parameters  //it also very effictive.
        return renderOutput(createStudentInfoActionService, parameters);
    }

    @GetMapping("/listStudent")
    @ResponseBody
    public String ListStudent(Map<String, Object> parameters) {

        return renderOutput(listStudentInfoActionService, parameters);
    }


}
