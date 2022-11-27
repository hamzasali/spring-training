package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {
    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Version", "Cydeo.V3")
                .body(new ResponseWrapper("courses successfully retrieved", courseService.getCourses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long courseId) {
        return ResponseEntity.ok(new ResponseWrapper("course:" + courseId + " retrieved", courseService.getCourseById(courseId)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCourse(@RequestBody CourseDTO course) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Operation", "Create")
                .body(new ResponseWrapper("Course Created", courseService.createCourse(course)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseWrapper> updateCourse(@PathVariable("id") long courseId, @RequestBody CourseDTO course) {
        courseService.updateCourse(courseId, course);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Operation", "Updated")
                .body(new ResponseWrapper("Course:" + courseId + " updated", courseService.getCourseById(courseId)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseWrapper> deleteCourseById(@PathVariable("id") long courseId) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.ok(new ResponseWrapper("Course:" + courseId + " deleted"));
    }
}
