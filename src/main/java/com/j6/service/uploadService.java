package com.j6.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface uploadService {

	File save(MultipartFile file, String folder);

}
