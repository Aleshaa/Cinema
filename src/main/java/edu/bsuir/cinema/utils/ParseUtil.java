package edu.bsuir.cinema.utils;

import edu.bsuir.cinema.model.Film;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Alesha on 01.10.2016.
 */
public class ParseUtil {

    public static boolean isNumber(String str) {
        return str.matches("[-+]?\\d+");
    }

    public static void writeIntoExcel(List<Film> list) throws FileNotFoundException, IOException {
        File file = new File("D:\\example.xlsx");
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(list.get(i).getName());
            row.createCell(1).setCellValue(list.get(i).getCountry());
            row.createCell(2).setCellValue(list.get(i).getYear().toString());
            row.createCell(3).setCellValue(list.get(i).getDuration().toString());
        }
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
    }
}
