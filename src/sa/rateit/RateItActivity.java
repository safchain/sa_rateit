package sa.rateit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;


public class RateItActivity extends Activity {
	private Context context;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		
		showDialog();
	}

	private void showDialog() {
		LayoutInflater factory = LayoutInflater
				.from(context);
		final View rateItEntryView = factory
				.inflate(R.layout.rateit_layout, null);
	
		final AlertDialog dialog = new AlertDialog.Builder(
				this).setTitle("Rate It, Please")
				.setView(rateItEntryView).create();

		final Button laterButton = (Button) rateItEntryView
				.findViewById(R.id.laterButton);
		laterButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				dialog.dismiss();
				RateItActivity.this.finish();
			}
		});
		final Button neverButton = (Button) rateItEntryView
				.findViewById(R.id.neverButton);
		neverButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				RateItUtils.setStartCount(context, -1);
				dialog.dismiss();
				RateItActivity.this.finish();
			}
		});
		final Button nowButton = (Button) rateItEntryView
				.findViewById(R.id.nowButton);
		nowButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				RateItUtils.setStartCount(context, -1);
				dialog.dismiss();
				RateItActivity.this.finish();

				Intent marketIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("market://details?id=" + RateItUtils.getApplicationName(context)));
				marketIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
						| Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
				startActivity(marketIntent);
			}
		});

		dialog.show();
	}
}
