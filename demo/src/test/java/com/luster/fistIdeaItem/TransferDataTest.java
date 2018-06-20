package com.luster.fistIdeaItem;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransferDataTest {
    public static void main(String[] args) throws Exception {

        Map<String, Integer> districtMap = new HashMap<>();

        Pattern tablePattern = Pattern.compile("CREATE TABLE `.+`"); //
        Pattern fieldPattern = Pattern.compile("`.+` .+\\(.+\\)"); //

        //读
        String filePath = "E:\\捷视\\惠州水务\\cmv3_structure.sql";//绝对路径
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        //写
        FileOutputStream fos = new FileOutputStream(new File("E:\\捷视\\惠州水务\\data.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);

        String line = "";
        while (((line = br.readLine()) != null)) {
            Matcher matcher = tablePattern.matcher(line);
            while (matcher.find()) {
                bw.newLine();
                //读
                String store = matcher.group();
                //写
                bw.write(store);
                bw.newLine();
                continue;
            }
            Matcher fieldMatcher = fieldPattern.matcher(line);
            while (fieldMatcher.find()) {
                //读
                String store = fieldMatcher.group();
                //写
                if(!store.contains("FOREIGN KEY")) {
                    bw.write(store + "，");
                }
                continue;
            }
        }

        br.close();
        isr.close();
        fis.close();
        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();


    }

}
