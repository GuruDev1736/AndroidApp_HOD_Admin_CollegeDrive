package com.example.attend.dashboard.ui.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.attend.Autenthication.Admin_login;
import com.example.attend.R;
import com.example.attend.databinding.FragmentAdminProfileBinding;
import com.example.attend.databinding.FragmentDashboardBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class admin_profile extends Fragment {

    private FragmentAdminProfileBinding binding ;
    Button button ;
    FirebaseAuth auth ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAdminProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        auth = FirebaseAuth.getInstance();
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(view.getContext(),Admin_login.class));
                getActivity().finish();

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}