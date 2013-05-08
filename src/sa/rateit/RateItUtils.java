package sa.rateit;

import android.content.Context;
import android.content.SharedPreferences;

public class RateItUtils {
	public static int getResourceInt(Context context, String name) {
		String packageName = context.getApplicationInfo().packageName;

		int nameResourceID = context.getResources().getIdentifier(name,
				"string", packageName);
		if (nameResourceID == 0)
			return 0;
		else
			return Integer.parseInt(context.getString(nameResourceID));
	}

	public static void setStartCount(Context context, int num) {
		SharedPreferences prefs = context.getSharedPreferences(
				getApplicationName(context), 0);

		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("StartCount", num).commit();
	}

	public int getStartCount(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(
				getApplicationName(context), 0);

		return prefs.getInt("StartCount", 1);
	}

	public static String getApplicationName(Context context) {
		int stringId = context.getApplicationInfo().labelRes;
		return context.getString(stringId);
	}
}
