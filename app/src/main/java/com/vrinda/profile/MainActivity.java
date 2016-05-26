package com.vrinda.profile;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.vrinda.profile.Model.Constants;
import com.vrinda.profile.Model.PersonalDetails;
import com.vrinda.profile.view.PersonalDetailsListFragment;
import com.vrinda.profile.view.PersonalProfileFragment;

/**
 * Created by vrinda venugopal on 5/24/2016.
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_details_main_view);

        PersonalDetailsListFragment personalDetailsListFragment = new PersonalDetailsListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.details_list_view, personalDetailsListFragment).commit();
        personalDetailsListFragment.setOnItemClick(new PersonalDetailsListFragment.ProfileClickListener() {
            @Override
            public void onProfileItemClick(PersonalDetails personalDetails) {
                PersonalProfileFragment mainFragment = new PersonalProfileFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constants.PROFILE_BUNDLE, personalDetails);
                mainFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.details_pane_view, mainFragment).commit();
            }
        });

    }
}
