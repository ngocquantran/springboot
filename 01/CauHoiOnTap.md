### <span style="color: green"> CÂU HỎI ÔN TẬP LESSON 1</span>

**1**. Ý nghĩa của groupId và artifactId khi tạo dự án Spring Boot:

- <span style="color: yellow">groupId</span> : ID của dự án để phân biệt với tất cả các dự án khác, gourpId là duy nhất và được sử dụng như là root package.
- <span style="color: yellow">artifactId</span> : để đặt tên cho dự án đang xây dựng

**2**. Cần phải tạo ngược tên miền trong `<groupId>vn.techmaster</groupId>`: tổ chức tên miền theo thứ tự từ cao đến thấp theo nguyên tắc đặt tên Unique Package Names để tránh trường hợp bị trùng tên (name collision).

**3**. Hai cơ chế để quản lý thư viện của Spring Boot:

- Maven
- Gradle

**4**. Tác dụng của file <span style="color: yellow">pom.xml</span>: chứa các thông tin cần thiết định nghĩa một dự án (tên dự án, version, nhóm pháp triển) và các thư viện, plugin được sử dụng

**5**. <span style="color: yellow">Dependency</span> trong file pom.xml là các thư viện mở rộng (phần phụ thuộc) mà người dùng thêm vào để sử dụng cho dự án của mình

**6**. <span style="color: yellow">@Controller</span> hoặc <span style="color: yellow">@RestController</span> là annotation để đánh dấu 1 class có chức năng như 1 controller (nơi tiếp nhận request và trả về response cho client)

**7**. <span style="color: yellow">@RequestMapping</span> là annotation có thể áp dụng cho cấp độ lớp hoặc phương thức trong controller để quy định cấu hình ánh xạ các web request.

Các tham số trong @RequestMapping có:

- name
- value
- method
- produces
- consumes
- defaultValue
- params
- headers

**8**. <span style="color: yellow">@RequestBody</span> chỉ định loại Object Java để Spring Boot chuyển chuỗi JSON trong Http request thành kiểu Object đó. Do vậy, tên và kiểu dữ liệu trong JSON phải trùng khớp với tên và kiểu trong kiểu Object được chỉ định

**9**.

- <span style="color: yellow">@RequestParam</span> nên được sử dụng trong trường hợp web request cần filter các đối tượng theo 1 hoặc 1 số điều kiện nào đó. Bên cạnh đó, trường hợp cần thêm điều kiện not required hoặc default cho tham số, dùng @RequestParam sẽ nhanh và gọn hơn.

- <span style="color: yellow">@PathVariable</span> nên được sử dụng trong trường hợp web request cần response các đối tượng từ một giá trị cụ thể nào đó hoặc tham số truyền vào cần match với một format nào đó mà cần dùng regex để kiểm tra.

**10**. Thứ tự các thành phần đường dẫn không thể hoán đổi do annotation @PathVariable sẽ lấy trự tiếp giá trị tham số trong đường dẫn, nếu truyền không đúng thứ tự tham số sẽ dẫn đến phương thức nhận sai tham số

**11**.

- <span style="color: yellow">@GetMapping</span> xử lý yêu cầu lấy dữ liệu

- <span style="color: yellow">@PostMapping</span> xử lý yêu cầu tạo dữ liệu

**12**. Trong các annotation <span style="color: yellow">@RequestMapping, @GetMapping, @PostMapping…</span> có tham số <span style="color: yellow">produces = MediaType.XXXX</span>. Tham số này dùng để quy định kiểu dữ liệu mà phương thức xử lý sẽ tạo ra ( ví dụ: JSON, XML)

**13**. Ý nghĩa của annotation <span style="color: yellow">@RequestBody</span> trong đoạn code bên dưới để chỉ định Spring sẽ chuyển dạng dữ liệu JSON trong HttpRequest body sang kiểu đối tượng Message trong java.

```java
@PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public Message echoMessage(@RequestBody Message message){
    return message;
}
```

**14**. Cách thay đổi cổng lắng nghe mặc định 8080:

```java
 public static void main(String[] args) {
        System.getProperties().put( "server.port", 8181 );
        SpringApplication.run(Demo3Application.class, args);
    }
```
