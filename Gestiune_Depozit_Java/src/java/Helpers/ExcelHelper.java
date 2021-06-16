/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author papad
 */

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelHelper {
   public static void export() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ExcelHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String sql = "SELECT l.name, l.tip, log.idLogs, log.operation, log.Date from login l, logs log where log.idLogin = l.id_user;";
 
            Statement statement = connection.createStatement();
 
            ResultSet result = statement.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Reviews");
 
            writeHeaderLine(sheet);
 
            writeDataLines(result, workbook, sheet);
 
            FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\papad\\Downloads\\startrek;starwars-8.1.2001.xlsx"));
            workbook.write(outputStream);
            workbook.close();
 
            statement.close();
            
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
 
    private static void writeHeaderLine(XSSFSheet sheet) {
 
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("ID Log");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Data");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Operatie");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("User");
 
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Rol");
    }
 
    private static void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            String idLog = result.getString("idLogs");
            String dataAct = result.getString("Date");
            String operation = result.getString("operation");
            String name = result.getString("name");
            String type = result.getString("tip");
 
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(idLog);
 
            cell = row.createCell(columnCount++);
 
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);
 
            cell.setCellValue(dataAct);
            
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(operation);

 
            cell = row.createCell(columnCount++);
            cell.setCellValue(name);
 
            cell = row.createCell(columnCount);
            cell.setCellValue(type);
 
        }
    } 
}
