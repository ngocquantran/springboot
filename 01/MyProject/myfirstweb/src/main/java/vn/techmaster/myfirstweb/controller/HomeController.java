package vn.techmaster.myfirstweb.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import vn.techmaster.myfirstweb.model.Book;
import vn.techmaster.myfirstweb.model.Message;
import vn.techmaster.myfirstweb.model.Student;
import vn.techmaster.myfirstweb.service.StudentService;


@RestController
@RequestMapping("/")
public class HomeController {

    static StudentService studentService = new StudentService();
    static ArrayList<Student> students = studentService.getAllStudent();


    @GetMapping(value = "/hi", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String hello() {
        return "<h1>Hello World</h1><h3>Cool</h3>";
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book getBook() {
        return new Book("Dế Mèn Phiêu Luu Ky", "Tô Hoài", "1945");
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Book book_xml() {
        return new Book("x111", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài");
    }

    @GetMapping("/add/{a}/{b}")
    @ResponseBody
    public int add(@PathVariable("a") int aa, @PathVariable("b") int bb) {
        return aa + bb;
    }

    @GetMapping("/name/{your_name}")
    @ResponseBody
    public String hi(@PathVariable("your_name") String yourName) {
        return "Hi " + yourName;
    }

    @GetMapping("/year/{year}")
    @ResponseBody
    public int getAge(@PathVariable("year") int year) {
        return Calendar.getInstance().get(Calendar.YEAR) - year;
    }

    @GetMapping("/random/{length}")
    @ResponseBody
    public String randomString(@PathVariable("length") int length) {
        return "XXXmmmMmmWW";
    }

    @GetMapping("/add")
    @ResponseBody
    public int add2(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a + b;
    }

    @PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message echoMessage(@RequestBody Message message) {
        return message;
    }

    @GetMapping("/random")
    public String getRandomStr() {
        String s = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 8; i++) {
            Random rd = new Random();
            int number = rd.nextInt(s.length());
            sb.append(s.charAt(number));
        }
        return sb.toString();
    }

    @GetMapping("/quote")
    public String getRandomQuote() {
        List<String> list = new ArrayList<>();
        list.add("Kiến tha lâu đầy tổ");
        list.add("Có công mài sắt, có ngày nên kim");
        list.add("Không thầy đố mày làm nên");
        list.add("Học thầy không tày học bạn");
        Random rd = new Random();
        int index = rd.nextInt(4);
        return list.get(index);
    }

    @PostMapping("/bmi")
    public double bmiCalulate(@RequestParam("h") double height, @RequestParam("w") double weight) {
        double bmi = weight / Math.pow(height, 2);
        return Math.floor(bmi * 1000) / 1000;
    }

    @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Student> addStudent(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("class") String className) {
        studentService.addNewStudent(students, id, name, className);
        return students;
    }


}
