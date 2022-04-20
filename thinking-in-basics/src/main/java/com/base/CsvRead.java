package com.base;

import com.base.entity.CheckTransInfoDto;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用opencsv读取.csv文件海里数据
 *
 * @author djq
 * @date 2021/12/13 11:37
 */
public class CsvRead {
    private static final int SIZE = 200;

    public static void main(String[] args) {
        try {
            String path = "C:\\Users\\user\\Desktop\\批量查询示例文件.csv";
            DataInputStream in = new DataInputStream(new FileInputStream(new File(path)));
            CSVReader csvReader = new CSVReader(new InputStreamReader(in, "utf-8"), CSVParser.DEFAULT_SEPARATOR,
                    CSVParser.DEFAULT_QUOTE_CHARACTER, CSVParser.DEFAULT_ESCAPE_CHARACTER, 1);
            String[] strs;
            List<CheckTransInfoDto> list = new ArrayList<>();
            CheckTransInfoDto dto = null;
            int i = 0;
            while ((strs = csvReader.readNext()) != null) {
                //System.out.println(Arrays.deepToString(strs));
                dto = new CheckTransInfoDto();
                // 将数据数据设置到实体对象中去
                list.add(setData(strs,dto));
                i++;
                // 当 list 到达单批次最大数量后，执行保存数据操作，并清空list
                if (i==SIZE){
                    throw new Exception("文件数量超过200条上线");
                }
            }
            System.out.println("读取到的内容集合："+list.toString());
            // 关闭流
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static CheckTransInfoDto setData(String[] strs, CheckTransInfoDto dto) {
        dto.setId(strs[0].trim());
        dto.setName(strs[1].trim());
        System.out.println(dto.toString());
        return dto;
    }
}
