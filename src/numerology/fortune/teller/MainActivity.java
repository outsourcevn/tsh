package self.cure.diabetes;


import java.util.Random;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import self.cure.diabetes.R;
import self.cure.diabetes.AdvManager;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	WebView webview;
	private AdView adView;
	private static final String AD_UNIT_ID = "ca-app-pub-6575239088642506/9081815672";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);				
		setContentView(R.layout.activity_main);		
		webview = (WebView) findViewById(R.id.webview);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setUseWideViewPort(true);
		//webview.getSettings().setPluginState(WebSettings.PluginState.ON);
		webview.getSettings().setBuiltInZoomControls(true);
		webview.loadUrl("file:///android_asset/demos/main/index2.html");
//		AdvManager.init(this.getBaseContext());
		Random r = new Random();
		int i1 = r.nextInt(2);
//		if (i1==0) AdvManager.displayInterstitial();
//		Log.e("quangcao",String.valueOf(i1));
		if (i1==0){
		adView = new AdView(this);
		adView.setAdSize(AdSize.BANNER);
		adView.setAdUnitId(AD_UNIT_ID);
		RelativeLayout rl = new RelativeLayout(this);
		RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.FILL_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		lay.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.layoutWeb);
		layout.addView(adView, lay);
		AdRequest adRequest = new AdRequest.Builder().build();
		adView.loadAd(adRequest);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}
}
