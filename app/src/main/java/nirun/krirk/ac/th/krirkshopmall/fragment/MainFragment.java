package nirun.krirk.ac.th.krirkshopmall.fragment;

import android.icu.text.Replaceable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nirun.krirk.ac.th.krirkshopmall.R;

/**
 * Created by nirun on 6/3/2561.
 */

public class MainFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        register controller
        registerController();


    }//        main method

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtnewregister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Replaceable
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFrameFragment,new RegisterFragment())
                        .addToBackStack(null)
                        .commit();


            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }
}
