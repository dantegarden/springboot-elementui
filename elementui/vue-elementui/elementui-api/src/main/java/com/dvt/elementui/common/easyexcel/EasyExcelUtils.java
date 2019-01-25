package com.dvt.elementui.common.easyexcel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.dvt.elementui.common.exception.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


/**
 * EasyExcel工具类
 * @author lij
 * 参考 https://github.com/HowieYuan/easyexcel-method-encapsulation
 * **/
public class EasyExcelUtils {

    /**
     * 读取 Excel(多个 sheet)
     *
     * @param excel    文件
     * @param clazz  继承 BaseRowModel 类
     * @return Excel 数据 list
     */
    public static <T extends BaseRowModel> List<T> readMultiSheetExcel(MultipartFile excel, Class<T> clazz) throws IOException {

        String filename = excel.getOriginalFilename();
        if (filename == null || (!filename.toLowerCase().endsWith(".xls") && !filename.toLowerCase().endsWith(".xlsx"))) {
            throw new BusinessException("扩展名不正确，文件格式错误！");
        }

        BaseExcelListener excelListener = new BaseExcelListener();
        ExcelReader reader = getReader(excel.getInputStream(), excelListener);
        if (reader == null) {
            return null;
        }
        for (Sheet sheet : reader.getSheets()) {
            if (clazz != null) {
                sheet.setClazz(clazz);
            }
            reader.read(sheet);
        }
        return excelListener.getTypedDatas();
    }

    /**
     * 读取某个 sheet 的 Excel，表头固定1行
     *
     * @param excel    文件
     * @param clazz 继承 BaseRowModel 类
     * @param sheetNo  sheet 的序号 从1开始
     * @return Excel 数据 list
     */
    public static <T extends BaseRowModel> List<T> readExcel(MultipartFile excel, Class<T> clazz, int sheetNo) throws IOException {
        return readExcel(excel, clazz, sheetNo, 1);
    }

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel       文件
     * @param clazz       继承 BaseRowModel 类
     * @param sheetNo     sheet 的序号 从1开始
     * @param headLineNum 表头行数，默认为1
     * @return Excel 数据 list
     */
    public static <T extends BaseRowModel> List<T> readExcel(MultipartFile excel, Class<T> clazz, int sheetNo,
                                         int headLineNum) throws IOException {

        String filename = excel.getOriginalFilename();
        if (filename == null || (!filename.toLowerCase().endsWith(".xls") && !filename.toLowerCase().endsWith(".xlsx"))) {
            throw new BusinessException("扩展名不正确，文件格式错误！");
        }

        BaseExcelListener excelListener = new BaseExcelListener();
        ExcelReader reader = getReader(excel.getInputStream(), excelListener);
        if (reader == null) {
            return null;
        }
        reader.read(new Sheet(sheetNo, headLineNum, clazz));
        return excelListener.getTypedDatas();
    }

    /**
     * 读取某个 sheet 的 Excel，表头固定1行
     *
     * @param excel    文件
     * @param clazz 继承 BaseRowModel 类
     * @param sheetNo  sheet 的序号 从1开始
     * @return Excel 数据 list
     */
    public static <T extends BaseRowModel> List<T> readExcel(File excel, Class<T> clazz, int sheetNo) throws IOException {
        return readExcel(excel, clazz, sheetNo, 1);
    }

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel       文件
     * @param clazz       继承 BaseRowModel 类
     * @param sheetNo     sheet 的序号 从1开始
     * @param headLineNum 表头行数，默认为1
     * @return Excel 数据 list
     */
    public static <T extends BaseRowModel> List<T> readExcel(File excel, Class<T> clazz, int sheetNo, int headLineNum) throws IOException {

        String filename = excel.getName();
        if (filename == null || (!filename.toLowerCase().endsWith(".xls") && !filename.toLowerCase().endsWith(".xlsx"))) {
            throw new BusinessException("扩展名不正确，文件格式错误！");
        }
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(excel);
            BaseExcelListener excelListener = new BaseExcelListener();
            ExcelReader reader = getReader(new FileInputStream(excel), excelListener);
            if (reader == null) {
                return null;
            }
            reader.read(new Sheet(sheetNo, headLineNum, clazz));
            return excelListener.getTypedDatas();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                fis.close();
            }
        }
        return null;
    }

    /**
     * 导出 Excel ：一个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导入文件的 sheet 名
     * @param clazz    映射实体类，Excel 模型
     */
    public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list,
                                  String fileName, String sheetName, Class<? extends BaseRowModel> clazz) {
        ExcelWriter writer = new ExcelWriter(getOutputStream(fileName, response), ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, clazz);
        sheet.setSheetName(sheetName);
        writer.write(list, sheet);
        writer.finish();
    }

    /**
     * 导出 Excel ：多个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导入文件的 sheet 名
     * @param clazz    映射实体类，Excel 模型
     */
    public static ExcelWriterFactroy writeExcelWithSheets(HttpServletResponse response, List<? extends BaseRowModel> list,
                                                          String fileName, String sheetName, Class<? extends BaseRowModel> clazz) {
        ExcelWriterFactroy writer = new ExcelWriterFactroy(getOutputStream(fileName, response), ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, clazz);
        sheet.setSheetName(sheetName);
        writer.write(list, sheet);
        return writer;
    }

    /**
     * 导出 Excel ：一个 sheet，带表头
     *
     * @param file      文件
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param sheetName 导入文件的 sheet 名
     * @param clazz    映射实体类，Excel 模型
     */
    public static void writeExcel(File file, List<? extends BaseRowModel> list, String sheetName, Class<? extends BaseRowModel> clazz) {
        ExcelWriter writer = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            writer = new ExcelWriter(fos, ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(1, 0, clazz);
            sheet.setSheetName(sheetName);
            writer.write(list, sheet);
            writer.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 导出文件时为Writer生成OutputStream
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) {
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        try {
            if (!dbfFile.exists() || dbfFile.isDirectory()) {
                dbfFile.createNewFile();
            }
            fileName = new String(filePath.getBytes(), "utf-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment;filename=" + filePath);
            return response.getOutputStream();
        } catch (IOException e) {
            throw new BusinessException("创建文件失败！");
        } finally{
            if(dbfFile.exists()){
                dbfFile.delete();
            }
        }
    }

    /**
     * 返回 ExcelReader
     *
     * @param inputStream   需要解析的 Excel 文件流
     * @param excelListener new ExcelListener()
     */
    private static ExcelReader getReader(InputStream inputStream, BaseExcelListener excelListener) {
        return new ExcelReader(inputStream, null, excelListener, false);
    }
}
