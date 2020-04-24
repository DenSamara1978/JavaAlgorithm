package Company;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ExcelReader {
    private final String fileName;

    public ExcelReader ( String fileName ) {
        this.fileName = fileName;

    }

    public CompanyPool parse () throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(fileName));
        Sheet sheet = workbook.getSheetAt(0);

        CompanyPool pool = new CompanyPool();
        String headCompanyName = "";
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell parentCell = cellIterator.next();
            Cell filialCell = cellIterator.next();
            Cell planCell = cellIterator.next();
            Cell factCell = cellIterator.next();

            if ( !parentCell.toString().isEmpty()) {
                headCompanyName = parentCell.toString();
                pool.addHeadCompany( headCompanyName );
            }
            pool.addFilialCompany( filialCell.toString(), headCompanyName, planCell.toString(), factCell.toString() );
        }
        return pool;
    }
}