package pl.mg6.programistamag.wimm;

import java.util.ArrayList;
import java.util.List;

public class InnerClassesExampleModel {

	private static final InnerClassesExampleModel instance = new InnerClassesExampleModel();
	
	private List<Object> dataStore;
	
	private InnerClassesExampleModel() {
		dataStore = new ArrayList<Object>();
	}
	
	public static InnerClassesExampleModel getInstance() {
		return instance;
	}
	
	public void addData(Object data) {
		dataStore.add(data);
	}
}
