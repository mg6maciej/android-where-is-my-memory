package pl.mg6.programistamag.wimm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class BrutalExampleParentActivity extends Activity {

	public static BrutalExampleParentActivity instance;
	
	private CheckBox enableSoundCheckBox;
	private CheckBox enableVibrationCheckBox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brutal_example_parent);
		enableSoundCheckBox = (CheckBox) findViewById(R.id.bep_enable_sound);
		enableVibrationCheckBox = (CheckBox) findViewById(R.id.bep_enable_vibration);

		instance = this;
	}
	
	public void onNextClick(View view) {
		Intent intent = new Intent(this, BrutalExampleChildActivity.class);
		startActivity(intent);
	}
	
	public boolean isEnableSound() {
		return enableSoundCheckBox.isChecked();
	}
	
	public boolean isEnableVibration() {
		return enableVibrationCheckBox.isChecked();
	}
}
