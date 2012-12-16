package pl.mg6.programistamag.wimm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

public class InnerClassesPartThreeExampleActivity extends FragmentActivity {
	
	private static final int EXAMPLE_DIALOG_ID = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inner_classes_part_3_example);
	}
	
	private static Dialog createExampleDialog(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(R.string.async_return_message);
		builder.setPositiveButton(R.string.ok, null);
		return builder.create();
	}
	
	public void onRunTaskOldDialogClick(View view) {
		ExampleOldDialogAsyncTask task = new ExampleOldDialogAsyncTask();
		task.execute((Void) null);
	}
	
	private class ExampleOldDialogAsyncTask extends AsyncTask<Void, Void, Void> {
		
		@Override
		protected Void doInBackground(Void... params) {
			// pretending to be executing long running code
			SystemClock.sleep(5000);
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			showDialog(EXAMPLE_DIALOG_ID);
		}
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
			case EXAMPLE_DIALOG_ID: {
				return createExampleDialog(this);
			}
		}
		return super.onCreateDialog(id);
	}
	
	public void onRunTaskNewDialogClick(View view) {
		ExampleNewDialogAsyncTask task = new ExampleNewDialogAsyncTask();
		task.execute((Void) null);
	}
	
	private class ExampleNewDialogAsyncTask extends AsyncTask<Void, Void, Void> {
		
		@Override
		protected Void doInBackground(Void... params) {
			// pretending to be executing long running code
			SystemClock.sleep(5000);
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			showExampleDialogFragment();
		}
	}
	
	private void showExampleDialogFragment() {
		
		FragmentManager fm = getSupportFragmentManager();
		ExampleDialogFragment dialogFragment = new ExampleDialogFragment();
		dialogFragment.show(fm, "dialog");
	}
	
	public static class ExampleDialogFragment extends DialogFragment {
		
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			return createExampleDialog(getActivity());
		}
	};
}
