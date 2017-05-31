package com.prodapt.app.dao.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import com.prodapt.app.dao.AppDao;

import au.com.bytecode.opencsv.CSVReader;

@Component
public class AppDaoImpl implements AppDao {

	@Override
	public List<String[]> getResult(String appname) throws IOException {

		List<String[]> lstresult = new ArrayList<String[]>();
		CSVReader csvReader;
		String[] nextLine;
		FileOutputStream out;
		File tempFile = File.createTempFile("data", ".csv");
		tempFile.deleteOnExit();
		out = new FileOutputStream(tempFile);
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(
				this.getClass().getClassLoader());
		Resource[] resources = resourcePatternResolver.getResources("classpath*:/data.csv");
		IOUtils.copy(resources[0].getInputStream(), out);
		csvReader = new CSVReader(new FileReader(tempFile), ',');
		csvReader.readNext();
		while ((nextLine = csvReader.readNext()) != null) {

			if (null != appname && !"".equals(appname)) {
				if (nextLine[1].toLowerCase().contains(appname.toLowerCase())) {
					lstresult.add(nextLine);
				}
			} else {
				lstresult.add(nextLine);
			}

		}
		out.close();
		csvReader.close();
		return lstresult;
	}

}
