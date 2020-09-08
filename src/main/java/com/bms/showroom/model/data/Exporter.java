package com.bms.showroom.model.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.function.Consumer;

import org.jooq.lambda.Unchecked;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exporter {

	@SneakyThrows
	public File exportFile(String fileName, Consumer<Writer> contentWriter) throws Exception {

		File file = new File(fileName);

		try (Writer writer = new FileWriter(file)) {
			contentWriter.accept(writer);

		} catch (Exception e) {
			log.debug("Panic! " + e.getMessage()); // TERROR Driven Development

		}
		return file;
	}

	
}

