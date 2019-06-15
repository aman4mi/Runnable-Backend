package com.bits.bitsDemo.controller;

import com.bits.bitsDemo.common.BaseController;
import com.bits.bitsDemo.entity.StudentInfo;
import com.bits.bitsDemo.repository.StudentInfoRepository;
import com.bits.bitsDemo.services.action.studentinfo.CreateStudentInfoActionService;
import com.bits.bitsDemo.services.action.studentinfo.ListStudentInfoActionService;
import com.bits.bitsDemo.services.action.studentinfo.SelectStudentInfoActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by aman.ullah on 2/26/2019.
 */
@Controller
public class StudentController extends BaseController {

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    private CreateStudentInfoActionService createStudentInfoActionService;
    private ListStudentInfoActionService listStudentInfoActionService;
    private SelectStudentInfoActionService selectStudentInfoActionService;

    @Autowired
    public StudentController(CreateStudentInfoActionService createStudentInfoActionService
            , ListStudentInfoActionService listStudentInfoActionService
            , SelectStudentInfoActionService selectStudentInfoActionService) {
        this.createStudentInfoActionService = createStudentInfoActionService;
        this.listStudentInfoActionService = listStudentInfoActionService;
        this.selectStudentInfoActionService = selectStudentInfoActionService;
    }


    @GetMapping("/admin/student")
    public String showStudent() {
        return "view/student/show";
    }

    @GetMapping("/admin/createStudent")
    public String createStudent() {
        return "view/student/create/show";
    }

    @GetMapping("/admin/studentRestShow")
    public String studentRestShow() {
        return "view/studentrest/show"; // this is to rest UI
    }

    @RequestMapping(value = "/admin/saveStudent", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(@RequestParam Map<String, Object> parameters) throws Exception {
        // @RequestParam MultiValueMap parameters  //it also very effictive.
        return renderOutput(createStudentInfoActionService, parameters);
    }

    @GetMapping("/admin/listStudent")
    @ResponseBody
    public String ListStudent(Map<String, Object> parameters) {

        return renderOutput(listStudentInfoActionService, parameters);
    }

    @GetMapping("/admin/selectStudent")
    @ResponseBody
    public StudentInfo studentInfowsw(@RequestParam Map<String, Object> parameters) {

//        StudentInfo studentInfo = studentInfoRepository.findById(Long.parseLong((String) parameters.get("id")));
        return selectStudentInfoActionService.studentInfo(parameters);
//        return renderOutput(selectStudentInfoActionService, parameters);
    }


}
