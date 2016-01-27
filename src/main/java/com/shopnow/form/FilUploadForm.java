package com.shopnow.form;

import org.springframework.web.multipart.MultipartFile;

public class FilUploadForm {

	private MultipartFile file;

	public MultipartFile getFile() {
		return this.file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
