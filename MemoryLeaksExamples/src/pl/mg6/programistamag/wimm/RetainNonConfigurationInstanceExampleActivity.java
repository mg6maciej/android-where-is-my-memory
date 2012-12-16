package pl.mg6.programistamag.wimm;

import android.app.Activity;
import android.os.Bundle;

public class RetainNonConfigurationInstanceExampleActivity extends Activity {
	
	Object lastNonConf;
	byte[] data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		lastNonConf = getLastNonConfigurationInstance();
		data = new byte[10485760];
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return this;
	}
}
