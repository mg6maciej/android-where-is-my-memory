package pl.mg6.programistamag.wimm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final ExampleStartInfo[] data = new ExampleStartInfo[] {
				new ExampleStartInfo(BrutalExampleParentActivity.class, getString(R.string.example_brutal)),
				new ExampleStartInfo(WarnedBySystemExampleActivity.class, getString(R.string.example_warned)),
				new ExampleStartInfo(RomainDrawableExampleActivity.class, getString(R.string.example_romain_drawable)),
				new ExampleStartInfo(InnerClassesPartOneExampleActivity.class, getString(R.string.example_inner_classes_part_1)),
				new ExampleStartInfo(InnerClassesPartTwoExampleActivity.class, getString(R.string.example_inner_classes_part_2)),
				new ExampleStartInfo(InnerClassesPartThreeExampleActivity.class, getString(R.string.example_inner_classes_part_3)),
				new ExampleStartInfo(UsingWebViewExampleActivity.class, getString(R.string.example_using_webview)),
				new ExampleStartInfo(RetainNonConfigurationInstanceExampleActivity.class, getString(R.string.example_retain_nonconfiguration_instance)),
		};
		ListAdapter adapter = new ArrayAdapter<ExampleStartInfo>(this, android.R.layout.simple_list_item_1, data);
		final ListView listView = (ListView) findViewById(R.id.main_listview);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(MainActivity.this, data[position].activityClass);
				startActivity(intent);
			}
		});
	}
	
	private static class ExampleStartInfo {
		
		private final Class<?> activityClass;
		private final String displayName;
		
		public ExampleStartInfo(Class<?> activityClass, String displayName) {
			this.activityClass = activityClass;
			this.displayName = displayName;
		}
		
		@Override
		public String toString() {
			return displayName;
		};
	}
	
	public static void unbindDrawables(View view) {
		if (view.getBackground() != null) {
			view.getBackground().setCallback(null);
		}
		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
				unbindDrawables(((ViewGroup) view).getChildAt(i));
			}
			((ViewGroup) view).removeAllViews();
		}
	}
}
