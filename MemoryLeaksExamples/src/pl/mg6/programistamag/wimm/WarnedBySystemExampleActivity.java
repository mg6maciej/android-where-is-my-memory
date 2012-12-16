package pl.mg6.programistamag.wimm;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class WarnedBySystemExampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.warned_by_system_example);
	}
	
	public void onOpenDialogClick(View view) {
		ProgressDialog dialog = new ProgressDialog(this);
		dialog.setTitle(R.string.dialog);
		dialog.setMessage(getString(R.string.rotate_to_leak));
		dialog.show();
	}
	
	public void onRegisterReceiverClick(View view) {
		IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(new ExampleReceiver(), intentFilter);
	}
	
	private static class ExampleReceiver extends BroadcastReceiver {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
			int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
			Log.i("battery", String.format("level: %d, status: %d", level, status));
		}
	}
}
