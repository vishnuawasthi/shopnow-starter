/**
 * 
 */
package com.shopnow.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author vawasthi
 * 
 */
@Component
public class FileUploadUtils {
	private static Logger logger = Logger.getLogger(FileUploadUtils.class);
	/**
	 * This generic class mehod is used to perform logging.
	 * 
	 * @param logger
	 *            is the object of class specific org.apache.log4j.Logger
	 * @param methodName
	 *            name of the method on which logging is performed
	 * @param startOrEnd
	 *            true if it is the start of the method or false if end.
	 */
	public void doLogging(Logger logger, String methodName, Boolean startOrEnd) {
		if (startOrEnd) {
			logger.info(" : " + methodName + "  -  start");
		} else {
			logger.info(" : " + methodName + "  -  end");
		}
	}
	/**
	 * This method creates a file on specified location.
	 * @param file, Object of MultipartFile
	 * @param request, HttpServletRequest
	 * @param type accepts two params either VIDEO or IMAGE 
	 * @return file name of create file 
	 * @throws IOException 
	 */
	public String createFile(MultipartFile file, HttpServletRequest request,String type) throws IOException {
		doLogging(logger, "createFile", true);
		// String rootPath = System.getProperty("catalina.home");
		File tempFile = null;
		String displayPictureName = file.getOriginalFilename();
		String fileName = StringUtils.getFilename(displayPictureName).substring(0, displayPictureName.lastIndexOf("."));
		String fileExtension = StringUtils.getFilenameExtension(displayPictureName);
		String realRootPath = request.getSession().getServletContext().getRealPath("/");
		if ("VIDEO".equalsIgnoreCase(type)) {
			tempFile = File.createTempFile(fileName + "_", "." + fileExtension, new File(realRootPath + "/videos/"));
		} else  if("IMAGE".equalsIgnoreCase(type)){
			tempFile = File.createTempFile(fileName + "_", "." + fileExtension, new File(realRootPath + "/uploadedImages/"));
		}
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
		file.transferTo(tempFile);
		doLogging(logger, "createFile", false);
		return	!StringUtils.isEmpty(tempFile)?tempFile.getName():null;
	}

}
