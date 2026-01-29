package com.example.courseenroll.controller;

import com.example.courseenroll.common.Result;
import com.example.courseenroll.entity.Course;
import com.example.courseenroll.req.CourseReq;
import com.example.courseenroll.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/list")
    public Result listCourses() {
        List<Course> courseList = courseService.getAllCourses();
        return Result.success(courseList);
    }

    @PostMapping("/available")
    public Result getAvailableCourses(@RequestBody CourseReq courseReq) {
        List<Course> availableCourseList = courseService.getAvailableCourses(courseReq);
        return Result.success(availableCourseList);
    }

    @GetMapping("/myCourses")
    public Result getMyCourses(@RequestParam Long studentId) {
        // 需要新增一个方法：根据 studentId 查询已报名课程
        List<Course> courseList = courseService.getEnrolledCoursesByStudent(studentId);
        return Result.success(courseList);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Long id) {
        Course course = courseService.getById(id);
        return Result.success(course);
    }

    @PostMapping
    public Result create(@RequestBody Course course) {
        courseService.create(course);
        return Result.success("创建成功！");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        courseService.update(course);
        return Result.success("更新成功！");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        courseService.delete(id);
        return Result.success("删除成功！");
    }

}