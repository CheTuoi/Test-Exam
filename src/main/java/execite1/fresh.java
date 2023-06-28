public class fresh {
    public static void main (String[] args){
        execite1 x = new execite1();
        int daysBetween = x.getDaysBetweenDates("20170220", "20211224");
        System.out.println("Tổng số ngày giữa hai ngày là: " + daysBetween);
        String add = x.addMonths("19980922", 3);
        System.out.println("Ngày sau khi cộng thêm:" + add);
    }
}
