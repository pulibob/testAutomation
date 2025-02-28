package com.kafka.test_automation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class Utilty {




    public  String getJsonString(String testCaseName){
       return updateIdFromJsonString(getJsonStringFromCSV(testCaseName));
    }


    private  String getJsonStringFromCSV(String testCaseName) {
        try {
            ClassPathResource resource = new ClassPathResource("csv/test-data.xlsx");
            InputStream file = resource.getInputStream();

            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0); // Read first sheet

            for (Row row : sheet) {
                Cell cellA = row.getCell(0); // Column A (Index 0)
                Cell cellB = row.getCell(1); // Column B (Index 1)

                if (cellA != null && cellB != null) {
                    String columnAValue = cellA.getStringCellValue().trim();
                    if (columnAValue.equals(testCaseName)) {
                        workbook.close();
                        file.close();
                        return cellB.getStringCellValue(); // Return matching Column B value
                    }
                }
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No Match Found"; // Return if no match is found
    }

    private String updateIdFromJsonString(String oldJson) {

        System.out.println("Before Update:::::" + oldJson);
        String updatedJson="";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(oldJson);

            String newId = UUID.randomUUID().toString();

            ((ObjectNode) rootNode).put("id", newId);

            updatedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);

            System.out.println("After Update JSON: \n");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return updatedJson;
    }

}
