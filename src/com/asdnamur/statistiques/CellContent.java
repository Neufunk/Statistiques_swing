package com.asdnamur.statistiques;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class CellContent {
    public static void CellContent() throws IOException, InvalidFormatException {

        // Récupère la valeur d'une cellule
        Workbook wb = WorkbookFactory.create(new File("C:/Users/johnathanv/Desktop/Namur 2017.xls"));
        String str = wb.getSheetAt(0).getRow(1).getCell(3).toString();
    }
}
