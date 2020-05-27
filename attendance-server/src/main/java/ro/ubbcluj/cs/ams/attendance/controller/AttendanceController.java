package ro.ubbcluj.cs.ams.attendance.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.cs.ams.attendance.dto.*;
import ro.ubbcluj.cs.ams.attendance.service.Service;
import ro.ubbcluj.cs.ams.attendance.service.exception.AttendanceExceptionType;
import ro.ubbcluj.cs.ams.attendance.service.exception.AttendanceServiceException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class AttendanceController {

    @Autowired
    Service service;

    private Logger logger = LogManager.getLogger(AttendanceController.class);


    @ApiOperation(value = "Add attendance info")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AttendanceExceptionType.class),
            @ApiResponse(code = 400, message = "DUPLICATE_ATTENDANCE_INFO", response = AttendanceExceptionType.class),
    })
    @RequestMapping(value = "/info", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttendanceInfoResponse> addAttendanceInfo(Principal principal, @RequestBody AttendanceInfoReq attendanceInfoReq, BindingResult result) {

        if (result.hasErrors())
            throw new AttendanceServiceException("Invalid attendance_info " + attendanceInfoReq, AttendanceExceptionType.INVALID_ATTENDANCE_INFO, HttpStatus.BAD_REQUEST);

        logger.info(principal.getName());
        AttendanceInfoResponse attendanceInfoResponse = service.addAttendanceInfo(attendanceInfoReq, principal.getName());

        return new ResponseEntity<>(attendanceInfoResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Add attendance")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AttendanceExceptionType.class),
            @ApiResponse(code = 400, message = "INVALID_TIME", response = AttendanceExceptionType.class),
    })
    @RequestMapping(value = "/student", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentAttendanceResponse> addAttendance(Principal principal, @RequestBody @Valid AttendanceRequest attendanceRequest, BindingResult result) {

        if (result.hasErrors())
            throw new AttendanceServiceException("Invalid attendance " + attendanceRequest, AttendanceExceptionType.INVALID_ATTENDANCE, HttpStatus.BAD_REQUEST);

        logger.info("++++++ addAttendace with attendance info id : " + attendanceRequest.getAttendanceInfoId() + "++++++++++++++");

        StudentAttendanceResponse attendanceResponse = service.addAttendance(attendanceRequest, principal.getName());

        return new ResponseEntity<>(attendanceResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all subjects")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AttendanceExceptionType.class),
            @ApiResponse(code = 400, message = "ERROR", response = AttendanceExceptionType.class),
    })
    @RequestMapping(value = "/subjects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SubjectResponse>> getAllSubjects(Principal principal) {

        logger.info("+++++++++ LOGGING getAllSubjects+++++++++");

        logger.info(principal.getName());
        List<SubjectResponse> subjects = service.findAllSubjects();
        logger.info("+++++++++SUCCESSFUL LOGGING getAllSubjects+++++++++");

        return new ResponseEntity<>(subjects, HttpStatus.OK);


    }

    @ApiOperation(value = "Get all activities")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AttendanceExceptionType.class),
            @ApiResponse(code = 400, message = "ERROR", response = AttendanceExceptionType.class),
    })
    @RequestMapping(value = "/activities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActivityResponse>> getAllActivities(Principal principal) {

        logger.info("+++++++++ LOGGING getAllActivities+++++++++");

        logger.info(principal.getName());
        List<ActivityResponse> activities = service.findAllActivities();
        logger.info("+++++++++SUCCESSFUL LOGGING getAllActivities+++++++++");

        return new ResponseEntity<>(activities, HttpStatus.OK);


    }

    @ApiOperation(value = "Get all attendances")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AttendanceExceptionType.class),
            @ApiResponse(code = 400, message = "ERROR", response = AttendanceExceptionType.class),
    })
    @RequestMapping(value = "/attendances", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AttendanceResponse>> getAllAttendances(Principal principal) {

        logger.info("+++++++++ LOGGING getAllAttendances+++++++++");

        logger.info(principal.getName());
        List<AttendanceResponse> attendanceResponses = service.getAllAttendances();
        logger.info("+++++++++SUCCESSFUL LOGGING getAllAttendances+++++++++");

        return new ResponseEntity<>(attendanceResponses, HttpStatus.OK);


    }

    @ApiOperation(value = "Get all attendances for course and week")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AttendanceExceptionType.class),
            @ApiResponse(code = 400, message = "ERROR", response = AttendanceExceptionType.class),
    })
    @RequestMapping(value = "/view", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AttendanceResponseForView>> getAllAttendancesForCourseAndWeek(Principal principal, @RequestBody @Valid AttendanceRequestForView attendanceRequest, BindingResult result) {

        logger.info("+++++++++ LOGGING getAllAttendances for course and week+++++++++");

        logger.info(principal.getName());
        List<AttendanceResponseForView> attendanceResponses = service.getAllAttendancesForCourseAndWeek(attendanceRequest.getCourse_id(), attendanceRequest.getActivity_id(), attendanceRequest.getWeek());
        logger.info("+++++++++SUCCESSFUL LOGGING getAllAttendances for course and week+++++++++");

        return new ResponseEntity<>(attendanceResponses, HttpStatus.OK);


    }


    @ExceptionHandler({AttendanceServiceException.class})
    @ResponseBody
    public ResponseEntity<AttendanceExceptionType> handleException(AttendanceServiceException exception) {

        return new ResponseEntity<>(exception.getType(), new HttpHeaders(), exception.getHttpStatus());
    }

}
