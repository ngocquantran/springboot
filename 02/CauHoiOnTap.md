## CÂU HỎI ÔN TẬP 2

1. Dùng kiểu dữ liệu ConcurrentHashMap trong dự án để:

   - Luôn đảo bảo ứng với 1 id duy nhất, chỉ có 1 sản phẩm
   - Truy cập dữ liệu theo id nhanh nhờ thuật toán mảng băm
   - ConcurrentHashMap là lớp đồng bộ, hỗ trợ chạy đa luồng

2. Để sinh 1 chuỗi ngẫu nhiên duy nhất, có thể dùng hàm UUID (Universal Unique Identifier).

3. Nếu không sử dụng khai báo <span style="color:yellow"> public record BookRequest(String title, String author, int year)</span> ta có thể khai báo theo class BookRequest thông thường và thêm điều kiện <span style="color:yellow"> final</span> cho các thuộc tính
