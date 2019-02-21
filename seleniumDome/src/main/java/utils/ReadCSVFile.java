package utils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author:stzhang
 * @date:2019-02-20
 * description:从本地区CSV文件里的内容返回给调用者
 */
public class ReadCSVFile {
    public static Iterator<Object[]> readCsvFile(String path) throws IOException {

        List<Object[]> dataArray = new ArrayList<Object[]>();
        Reader in = new FileReader(path);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            List<Object> rowList = new ArrayList<Object>();
            Iterator i = record.iterator();
            while(i.hasNext()){
                rowList.add(i.next());
            }
            System.err.println(rowList);
            Object[] rowArray = rowList.toArray();
            dataArray.add(rowArray);
        }
        return dataArray.iterator();
    }

    public static Object[][] readCSVFile(String path) throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String recode;
        while ((recode = file.readLine()) != null){
            String fields[] = recode.split(",");
            list.add(fields);
        }
        file.close();

        Object[][] results = new Object[list.size()][];
        for(int i=0;i<list.size();i++){
            results[i] = list.get(i);

        }
        return results;
    }
}