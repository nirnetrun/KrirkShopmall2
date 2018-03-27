package nirun.krirk.ac.th.krirkshopmall.fragment;

import android.icu.text.Replaceable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import nirun.krirk.ac.th.krirkshopmall.R;
import nirun.krirk.ac.th.krirkshopmall.utility.MyAlert;

/**
 * Created by nirun on 6/3/2561.
 */

public class MainFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        register controller
        registerController();

        // Login Controler
        loginControler();


    }//        main method

    private void loginControler() {
        Button button = getView().findViewById(R.id.btnlogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText userEditText = getView().findViewById(R.id.edtuser);
                EditText passwordEditText = getView().findViewById(R.id.edtpassword);

                String userString = userEditText.getText().toString().trim();
                String passwordString = passwordEditText.getText().toString().trim();

                if (userString.isEmpty() || passwordString.isEmpty()){

                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.title_have_space),
                            getString(R.string.message_have_space));
                }else {
          //          No space
                }
            }
        });
    }

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
