package com.qa.Utils;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Generate_FileUploadHelper{
    
    public static void uploadFile(WebDriver driver, WebElement fileInput, String fileFormat) {
        
    	//String fileFormat >>       this will come from stepDifinition to Class Page to Here
    	//WebElement "fileInput" >>  is coming from the Page Class
    	//WebDriver driver,>>        is coming from the Page Class
        
        // Get the absolute path of the file based on file format
        String filePath = getFilePath(fileFormat); 
        String absolutePath = new File(filePath).getAbsolutePath();
        
        // Upload the file
        fileInput.sendKeys(absolutePath);
    }

    private static String getFilePath(String fileFormat) {
        switch (fileFormat.toLowerCase()) {
//            case "jpg":
//                return "C:\\Users\\Ashok\\Downloads\\Passport6.jpg";
//            case "png":
//                return "C:\\Users\\Ashok\\Downloads\\Untitled.png";
//            case "pdf":
//                return "C:\\Users\\Ashok\\Downloads\\Free_Test_Data_100KB_PDF 1.pdf";
//            case "xlsx":
//                return "C:\\Users\\Ashok\\Downloads\\TestCase_Scenario.xlsx";
//            case "jpeg":
//                return "C:\\Users\\Ashok\\Downloads\\Passport6.jpeg";
//            case "txt":
//                return "C:\\Users\\Ashok\\Downloads\\LocalFolder.txt";
                
        
        case "jpeg_small":
            return "C:\\Users\\Ashok\\Documents\\Small-Sample-png-Image-File-Download.jpeg";
            
        case "jpeg_medium":
            return "C:\\Users\\Ashok\\Documents\\Medium_Sample-Image-file-Download.jpeg";
          case "jpeg_large":
          return "C:\\Users\\Ashok\\Documents\\Large-Sample-Image-download-for-Testing.jpeg";
                
         
            
//                
            case "jpg_small":
                return "C:\\Users\\Ashok\\Documents\\Small-Sample-png-Image-File-Download.jpg";
                
            case "jpg_medium":
                return "C:\\Users\\Ashok\\Documents\\Medium_Sample-Image-file-Download.jpg";
              case "jpg_large":
              return "C:\\Users\\Ashok\\Documents\\Large-Sample-Image-download-for-Testing.jpg";
               
              
//            case "png_small":
//              return "C:\\Users\\Ashok\\Documents\\Sample-Small-Image-PNG-file-Download.png";
            case "png_medium":
              return "C:\\Users\\Ashok\\Documents\\Medium_Sample-Image-file-Download.png";
            case "png_large":
              return "C:\\Users\\Ashok\\Documents\\Large-Sample-png-Image-download-for-Testing.png";

//                
              case "pdf_small":
                return "C:\\Users\\Ashok\\Documents\\small_sample-pdf-file.pdf";
            case "pdf_medium":
                return "C:\\Users\\Ashok\\Documents\\Medium_sample-pdf-download-10-mb.pdf";
            case "pdf_large":
               return "C:\\Users\\Ashok\\Documents\\Large_sample-50-MB-pdf-file.pdf";
              
              
            case "xlsx_small":
                return "C:\\Users\\Ashok\\Documents\\small_sample-xlsx-file-for-testing.xlsx";
            case "xlsx_medium":
                return "C:\\Users\\Ashok\\Documents\\medium_Sample-sales-data-excel.xlsx";
//            case "xlsx_large":
//               return "C:\\Users\\Ashok\\Documents\\.xlsx";
                
            case "mp4_small":
              return "C:\\Users\\Ashok\\Documents\\small_sample-mp4-file-small.mp4";
            case "mp4_medium":
              return "C:\\Users\\Ashok\\Documents\\MediumSample-MP4-Video-File-Download.mp4";
            case "mp4_large":
              return "C:\\Users\\Ashok\\Documents\\Large_98MB_Sample-Video-File-For-Testing.mp4";
                
            case "txt_small":
                return "C:\\Users\\Ashok\\Documents\\small_SampleTextFile_50kb.txt";
              case "txt_medium":
                return "C:\\Users\\Ashok\\Documents\\Medium_SampleTextFile_100kb.txt";
              case "txt_large":
                return "C:\\Users\\Ashok\\Documents\\Large_sample-2mb-text-file.txt";
                
              case "docx_small":
                  return "C:\\Users\\Ashok\\Documents\\smal_[MS-DOCX]-240220.docx";
              case "docx_large":
                  return "C:\\Users\\Ashok\\Documents\\Large_15-MB-docx-file-download.docx";
            // Add more cases as needed
            default:
                return "";
        }
    }
    	public static void uploadPassport(WebDriver driver, WebElement fileInput, String fileFormat) {
            
            
            // Get the absolute path of the file based on file format
            String filePath = getFilePaths(fileFormat); 
            String absolutePath = new File(filePath).getAbsolutePath();
            
            // Upload the file
            fileInput.sendKeys(absolutePath);
        }

        private static String getFilePaths(String fileFormat) {
            switch (fileFormat.toLowerCase()) {
//              
            case "Passport_jason":
                return "C:\\Users\\Ashok\\Documents\\Jason Passport 1.pdf";
                
            case "Passport2_jpg":
                return "C:\\Users\\Ashok\\Documents\\Passport2.jpg";
              case "Passport3_jpg":
              return "C:\\Users\\Ashok\\Documents\\Passport3.jpg";
              
              // Add more cases as needed
              default:
                  return "";
    }
}
}

