### DESCRIPTION FOR PROJECT

1. <span style="color:yellow">http://localhost:8080/random</span> trả về một chuỗi random string gồm 8 ký tự A-Z, a-z, 0-9

```java
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
```

Kết quả:
![](/readme_img/random1.PNG)

2. http://localhost:8080/quote trả về ngẫu nhiên một trong những câu tục ngữ

```java
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
```

Kết quả:
![](/readme_img/quote1.PNG)
![](/readme_img/quote2.PNG)

3. http://localhost:8080/bmi tính chỉ số BMI theo 2 tham số: weight, height người dùng gửi lên bằng phương thức POST, trả về chỉ số BMI index dạng số.

```java
 @PostMapping("/bmi")
    public double bmiCalulate(@RequestParam("h") double height, @RequestParam("w") double weight) {
        double bmi = weight / Math.pow(height, 2);
        return Math.floor(bmi * 1000) / 1000;
    }
```

Kết quả:
![](/readme_img/bmi1.PNG)

4. http://localhost:8080/student có 2 phương thức: GET, POST

- GET: trả về danh sách tất cả các student hiện có List&lt;Student&gt;
- POST: tạo mới một student thêm vào danh sách List&lt;Student&gt;

a. Bước 1: tạo đối tượng Student:
![](/readme_img/student1.PNG)

b. Bước 2: tạo class service thực hiện các chức năng cho Student
![](/readme_img/student2.PNG)

c. Bước 3: Khai báo danh sách Students trong class Controller
![](/readme_img/student3.PNG)

d. Bước 4: Tạo các phương thức xử lý web request

```java
 @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Student> addStudent(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("class") String className) {
        studentService.addNewStudent(students, id, name, className);
        return students;
    }

```

Kết quả:
![](/readme_img/student4.PNG)
![](/readme_img/student5.PNG)
