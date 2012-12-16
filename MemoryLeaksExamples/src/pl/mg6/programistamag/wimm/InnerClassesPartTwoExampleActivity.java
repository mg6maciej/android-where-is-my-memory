package pl.mg6.programistamag.wimm;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class InnerClassesPartTwoExampleActivity extends Activity {
	
	private static final int MSG_ID = 1;
	
	private TextView textView;
	
	private Handler handler;
	private Handler handlerAlsoBad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inner_classes_part_2_example);
		
		textView = (TextView) findViewById(R.id.ice_textview);
		
		handler = new ExampleHandler();
		handlerAlsoBad = new ExampleHandlerAlsoBad(this);
	}
	
	private void updateTextWithObject(Object object) {
		Log.i("update text", "Received object: " + object);
		textView.setText("Received object: " + object);
	}
	
	public void onDelayedMessageClick(View view) {
		Message msg = Message.obtain(handler, MSG_ID);
		msg.obj = "1234567890";
		handler.sendMessageDelayed(msg, 5000);
	}
	
	private class ExampleHandler extends Handler {
		
		@Override
		public void handleMessage(Message msg) {
			updateTextWithObject(msg.obj);
		}
	}
	
	public void onDelayedMessageAlsoBadClick(View view) {
		Message msg = Message.obtain(handlerAlsoBad, MSG_ID);
		msg.obj = "1234567890 (also bad)";
		handlerAlsoBad.sendMessageDelayed(msg, 5000);
	}
	
	private static class ExampleHandlerAlsoBad extends Handler {
		
		private WeakReference<InnerClassesPartTwoExampleActivity> parent;
		
		public ExampleHandlerAlsoBad(InnerClassesPartTwoExampleActivity parent) {
			this.parent = new WeakReference<InnerClassesPartTwoExampleActivity>(parent);
		}
		
		@Override
		public void handleMessage(Message msg) {
			InnerClassesPartTwoExampleActivity p = parent.get();
			if (p != null) {
				p.updateTextWithObject(msg.obj);
			}
		}
	}
}
