package com.Project.NiitShoppingApp_Frontend.Util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtility 
{
	private static final String ABS_PATH = "F:\\NiitShoppingAppProject\\NiitShoppingApp\\NiitShoppingApp_Frontend\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) 
	{
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images");
		
		logger.info(REAL_PATH);
		
		if(!new File(ABS_PATH).exists())
		{
			new File(ABS_PATH).mkdir();
		}
		
		if(!new File(REAL_PATH).exists())
		{
			new File(REAL_PATH).mkdir();
		}
		
		try 
		{
			file.transferTo(new File(REAL_PATH + code +".jpg"));
			file.transferTo(new File(ABS_PATH + code +".jpg"));
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		
	}

	

}
