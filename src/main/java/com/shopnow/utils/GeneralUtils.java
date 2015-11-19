package com.shopnow.utils;

import java.util.ArrayList;
import java.util.List;

public class GeneralUtils {
	public void executeBatch(List<String> namesList) {
		int listsize = namesList.size();
		List<String> subList = new ArrayList<String>();
		int BATCH_SIZE = 5;
		int fromIndex = 0;
		int toIndex = BATCH_SIZE;
		if (listsize >= BATCH_SIZE) {
			while (listsize >= BATCH_SIZE) {
				subList = namesList.subList(fromIndex, toIndex);
				// processList(subList);
				fromIndex = fromIndex + BATCH_SIZE;
				toIndex = toIndex + BATCH_SIZE;
				listsize = listsize - BATCH_SIZE;
			}
			if (listsize > 0) {
				subList = namesList.subList(fromIndex, namesList.size());
				// processList(subList);
			}
		} else {
			System.out.println("Records are very less");
			// processList(namesList);
		}

	}
}
