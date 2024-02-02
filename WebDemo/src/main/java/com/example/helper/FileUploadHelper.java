package com.example.helper;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	boolean b;

	public boolean uploadFile(MultipartFile file) {
		String filename = file.getOriginalFilename();

		try {
			FileOutputStream fos = new FileOutputStream(
					"C:\\Users\\shilpa\\eclipse-workspace\\WebDemo\\target\\classes\\static\\images\\"+filename);
			byte[] bytes = file.getBytes();
			fos.write(bytes);
			b = true;
		} catch (IOException e) {
			e.printStackTrace();
			b = false;
		}

		return b;
	}

}
