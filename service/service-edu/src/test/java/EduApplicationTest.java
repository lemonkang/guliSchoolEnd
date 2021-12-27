import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class EduApplicationTest {

    public static void main(String[] args) {
       String fileName="D:\\11.xlsx";
      EasyExcel.read(fileName,DemoDate.class,new ExcelListener()).sheet().doRead();

    }
}
