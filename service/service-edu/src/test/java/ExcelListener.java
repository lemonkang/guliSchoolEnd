import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

public class ExcelListener extends AnalysisEventListener<DemoDate> {
//    一行一行去读取Excel内容
    @Override
    public void invoke(DemoDate demoDate, AnalysisContext analysisContext) {
        System.out.println(demoDate.getSname());
    }
//    读取表头信息
     public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
         System.out.println("表头信息"+headMap.toString());
    }
//  读取完成后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完成后执行");

    }
}
