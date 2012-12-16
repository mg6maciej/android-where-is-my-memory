package pl.mg6.programistamag.wimm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class InnerClassesPartOneExampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inner_classes_part_1_example);
	}
	
	public void onAddDataClick(View view) {
		ExampleData data = new ExampleData("0987654321", 1024);
		InnerClassesExampleModel.getInstance().addData(data);
	}
	
	public class ExampleData {
		
		private final String name;
		private final int value;
		
		public ExampleData(String name, int value) {
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}
		
		public int getValue() {
			return value;
		}
	}
}
