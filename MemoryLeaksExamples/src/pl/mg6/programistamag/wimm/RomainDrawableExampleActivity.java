package pl.mg6.programistamag.wimm;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class RomainDrawableExampleActivity extends Activity {
	
	private static Drawable imageCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.romain_drawable_example);
		
		ImageView imageView = (ImageView) findViewById(R.id.rde_imageview);
		
		if (imageCache == null) {
			imageCache = getResources().getDrawable(R.drawable.big_icon);
		}
		
		imageView.setImageDrawable(imageCache);
	}
}
