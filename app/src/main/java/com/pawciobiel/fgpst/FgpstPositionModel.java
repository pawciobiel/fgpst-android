package com.pawciobiel.fgpst;


import android.provider.BaseColumns;
import android.util.Log;

import org.json.JSONObject;

import java.text.DecimalFormat;

public class FgpstPositionModel implements BaseColumns {
    public static final String TABLE_NAME = "positions";
    public static final String TIMESTAMP = "timestamp";
    public static final String POSITION_JSON = "position_json";

    public double lat;
    public double lon;
    public double altitude;
    public float speed;
    public float bearing;
    public String timestamp;
    public String device_key;


    public static double getDoubleValue(String value, int digit) {
        if (value == null) {
            value = "0";
        }
        double i = 0;
        try {
            DecimalFormat digitformat = new DecimalFormat("#.######");
            digitformat.setMaximumFractionDigits(digit);
            return Double.valueOf(digitformat.format(Double.parseDouble(value)));

        } catch (NumberFormatException numberFormatExp) {
            return i;
        }
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("lat", getDoubleValue(String.valueOf(lat), 6));
            json.put("lon", getDoubleValue(String.valueOf(lon), 6));
            json.put("altitude", altitude);
            json.put("speed", speed);
            json.put("bearing", bearing);
            json.put("timestamp", timestamp);
            json.put("device_key", device_key);
        } catch (org.json.JSONException exc) {
            Log.d(MY_TAG, "error generating json: " + exc.toString());
        }
        return json;
    }
}
