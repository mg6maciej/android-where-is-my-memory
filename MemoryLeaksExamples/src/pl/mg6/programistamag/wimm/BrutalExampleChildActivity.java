package pl.mg6.programistamag.wimm;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class BrutalExampleChildActivity extends Activity {
	
	private static final int VIBRATION_TIME = 500;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brutal_example_child);
	}
	
	public void onAttackClick(View view) {
		boolean enableSound = BrutalExampleParentActivity.instance.isEnableSound();
		boolean enableVibration = BrutalExampleParentActivity.instance.isEnableVibration();
		
		if (enableSound) {
			// ...
		}
		if (enableVibration) {
			Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
			vibrator.vibrate(VIBRATION_TIME);
		}
	}
}
