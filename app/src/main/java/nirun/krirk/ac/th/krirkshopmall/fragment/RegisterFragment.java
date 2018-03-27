package nirun.krirk.ac.th.krirkshopmall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import nirun.krirk.ac.th.krirkshopmall.MainActivity;
import nirun.krirk.ac.th.krirkshopmall.R;
import nirun.krirk.ac.th.krirkshopmall.utility.AddNewUserToserver;
import nirun.krirk.ac.th.krirkshopmall.utility.MyAlert;
import nirun.krirk.ac.th.krirkshopmall.utility.MyConstant;

/**
 * Created by nirun on 6/3/2561.
 */

public class RegisterFragment extends Fragment {
    // Explicat
    private String nameString,userString, passwordString,modeString;
    private boolean aBoolean = true;



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //create toolbar
        createToolbar();

        // radio control
        radioControl();


    }//main method

    private void radioControl() {
        RadioGroup radioGroup = getView().findViewById(R.id.ragmode);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                aBoolean = false;
                switch (i){
                    case R.id.radowner:
                        modeString = "OwnerShop";
                        break;
                    case R.id.radcustomer:
                        modeString = "CudtomShop";
                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.itemupload) {
            UploadtoServer();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void UploadtoServer() {

//        get value from

        EditText nameEdttext = getView().findViewById(R.id.edtneme);
        EditText userEdtText = getView().findViewById(R.id.edtuser);
        EditText passwordedttext = getView().findViewById(R.id.edtpassword);

        nameString = nameEdttext.getText().toString().trim();
        userString = userEdtText.getText().toString().trim();
        passwordString = passwordedttext.getText().toString().trim();


        // check Space
        if (nameString.isEmpty() || userString.isEmpty() || passwordString.isEmpty()) {
//            Have Space
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.myDialog(getString(R.string.title_have_space),
                    getString(R.string.message_have_space));
        } else if (aBoolean) {
//            Non Choose Mode
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.myDialog("Non Choose Mode", "Please Choose Mode");

        } else {
//            Choose Mode OK

                try {
                    MyConstant myConstant = new MyConstant();
                    AddNewUserToserver addNewUserToserver = new AddNewUserToserver(getActivity());
                    addNewUserToserver.execute(nameString, userString, passwordString, modeString, myConstant.getUrlAddUserString());

                    String result = addNewUserToserver.get();
                    if ( Boolean.parseBoolean(result)){
                        getActivity().getSupportFragmentManager().popBackStack();

                    }else {
                        Toast.makeText(getActivity(),"Press Try Again Cannot Add User",Toast.LENGTH_LONG).show();

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

        }// IF


    }// UPLOAD TOServer

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_register,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void createToolbar() {
        setHasOptionsMenu(true);


        Toolbar toolbar = getActivity().findViewById(R.id.toolbarregister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.register));

        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.message_have_space));

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }
}
