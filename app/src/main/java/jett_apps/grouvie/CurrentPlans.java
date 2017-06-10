package jett_apps.grouvie;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CurrentPlans {

    public static final String PLANS_KEY = "PLANS_KEY";


    //Obtain current plans
    public static ArrayList<Plan> getPlans(Context context) {

        Plan plan = new Plan("Test", "Test", "Test", "Test", null);

        SharedPreferences sp = context.getSharedPreferences(PLANS_KEY, Context.MODE_PRIVATE);
        final Gson gson = new Gson();

        String empty_list = gson.toJson(new ArrayList<Plan>());

        ArrayList<Plan> mSelectedList = gson.fromJson(sp.getString(PLANS_KEY, empty_list),
                new TypeToken<ArrayList<Plan>>() {}.getType());

        if (mSelectedList == null) {
            mSelectedList = new ArrayList<>();
        }

        return mSelectedList;

    }

    public static void addPlan(Plan plan, Context context) {

        //Obtain current plans
        ArrayList<Plan> currentPlans = getPlans(context);

        //Create new Gson to represent current plans with plan specified
        Gson gson = new Gson();

        if (currentPlans == null) {
            currentPlans = new ArrayList<Plan>();
        }
        currentPlans.add(plan);

        String jsonString = gson.toJson(currentPlans);
        SharedPreferences sp = context.getSharedPreferences(PLANS_KEY, Context.MODE_PRIVATE);

        //Save it through sharedPreferences
        sp.edit().putString(PLANS_KEY, jsonString).apply();

    }

    public static void deletePlan(Plan plan, Context context) {
        //Obtain current plans
        ArrayList<Plan> currentPlans = getPlans(context);

        //Create new Gson to represent current plans without plan specified
        Gson gson = new Gson();
        currentPlans.remove(plan);
        String jsonString = gson.toJson(currentPlans);
        SharedPreferences sp = context.getSharedPreferences(PLANS_KEY, Context.MODE_PRIVATE);

        //Save it through sharedPreferences
        sp.edit().putString(PLANS_KEY, jsonString).apply();

    }


}
