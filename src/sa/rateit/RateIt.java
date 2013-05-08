package sa.rateit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class RateIt {
	private SharedPreferences prefs;
	private int startThresHold = 3;
	private Context context;

	public RateIt(Context context) {
		this.context = context;

		prefs = context.getSharedPreferences(getApplicationName(context), 0);

		setStartThresHold(RateItUtils.getResourceInt(context,
				"rateit_startThresHold"));
	}

	public boolean prompt() {
		if (startThresHold == 0)
			return false;
		
		int startCount = getStartCount();
		if (startCount != -1) {
			setStartCount(++startCount);
			if (startCount % startThresHold == 0) {
				Intent rateit = new Intent(context, RateItActivity.class);
				rateit.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(rateit);

				return true;
			}
		}

		return false;
	}
	
	public void resetStartCount() {
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("StartCount", 0).commit();
	}

	public void setStartCount(int num) {
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("StartCount", num).commit();
	}

	public int getStartCount() {
		return prefs.getInt("StartCount", 1);
	}

	private String getApplicationName(Context context) {
		int stringId = context.getApplicationInfo().labelRes;
		return context.getString(stringId);
	}

	public int getStartThresHold() {
		return startThresHold;
	}

	public void setStartThresHold(int startThresHold) {
		this.startThresHold = startThresHold;
	}
}
