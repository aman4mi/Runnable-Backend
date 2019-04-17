package com.bits.bitsDemo.services.action.studentinfo;

import com.bits.bitsDemo.common.ActionInterface;
import com.bits.bitsDemo.entity.StudentInfo;
import com.bits.bitsDemo.repository.StudentInfoRepository;
import com.bits.bitsDemo.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by aman.ullah on 3/11/2019.
 */
@Service
@Component
public class CreateStudentInfoActionService extends BaseService implements ActionInterface {

     private StudentInfoRepository studentInfoRepository;
    private static String CREATE_SUCCESS_MESSAGE = "Successfully Created";


    @Autowired
    public CreateStudentInfoActionService(StudentInfoRepository studentInfoRepository) {
        this.studentInfoRepository = studentInfoRepository;
    }

    @Override
    public Map executePreCondition(Map parameters) {
        return parameters;
    }

    @Override
    public Map execute(Map previousResult) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(new Date());

        StudentInfo studentInfo = new StudentInfo();

        studentInfo.setStudentId((String) previousResult.get("studentId"));
        studentInfo.setStudentName((String) previousResult.get("studentName"));
        studentInfo.setCourseId((String) previousResult.get("courseId"));
        studentInfo.setCourseTitle((String) previousResult.get("courseTitle"));
        studentInfo.setDeptName((String) previousResult.get("deptName"));
        studentInfo.setSemesterInfo((String) previousResult.get("semesterInfo"));
        studentInfo.setCreatedBy("Me");
        studentInfo.setCreatedOn(dateString);

        studentInfoRepository.save(studentInfo);

        return previousResult;
    }

    @Override
    public Map executePostCondition(Map previousResult) {
        return previousResult;
    }

    @Override
    public Map buildSuccessResult(Map executeResult) {

        return super.setSuccess(executeResult, CREATE_SUCCESS_MESSAGE);
    }

    @Override
    public Map buildFailureResult(Map executeResult) {
        return executeResult;
    }
}
