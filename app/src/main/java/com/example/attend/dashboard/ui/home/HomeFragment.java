package com.example.attend.dashboard.ui.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.attend.Department.IT;
import com.example.attend.Department.civil;
import com.example.attend.Department.computer;
import com.example.attend.Department.e_and_tc;
import com.example.attend.Department.mechanical;
import com.example.attend.Department.pharmacy;
import com.example.attend.R;
import com.example.attend.databinding.FragmentHomeBinding;
import com.example.attend.teacher.CivilTeacherActivity;
import com.example.attend.teacher.ComputerTeacherActivity;
import com.example.attend.teacher.EandTCTeacherActivity;
import com.example.attend.teacher.ITTeacherActivity;
import com.example.attend.teacher.MechanicalTeacherActivity;
import com.example.attend.teacher.PharmacyTeacherActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.computerDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new MaterialAlertDialogBuilder(getContext(), R.style.AlertDialogTheme)
                        .setTitle("Select Category")
                        .setMessage("Select the following Option")
                        .setIcon(R.drawable.comp_dept)
                        .setPositiveButton("Teacher", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getContext(), ComputerTeacherActivity.class));
                            }
                        })
                        .setNeutralButton("Student", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(view.getContext(), computer.class));

                            }
                        })
                        .show();

            }
        });

        binding.mechanicalDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialAlertDialogBuilder(getContext(), R.style.AlertDialogTheme)
                        .setTitle("Select Category")
                        .setMessage("Select the following Option")
                        .setIcon(R.drawable.comp_dept)
                        .setPositiveButton("Teacher", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getContext(), MechanicalTeacherActivity.class));
                            }
                        })
                        .setNeutralButton("Student", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(view.getContext(), mechanical.class));

                            }
                        })
                        .show();

            }
        });

        binding.civilDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialAlertDialogBuilder(getContext(), R.style.AlertDialogTheme)
                        .setTitle("Select Category")
                        .setMessage("Select the following Option")
                        .setIcon(R.drawable.comp_dept)
                        .setPositiveButton("Teacher", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getContext(), CivilTeacherActivity.class));
                            }
                        })
                        .setNeutralButton("Student", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(view.getContext(), civil.class));

                            }
                        })
                        .show();

            }
        });

        binding.eAndTcDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialAlertDialogBuilder(getContext(), R.style.AlertDialogTheme)
                        .setTitle("Select Category")
                        .setMessage("Select the following Option")
                        .setIcon(R.drawable.comp_dept)
                        .setPositiveButton("Teacher", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getContext(), EandTCTeacherActivity.class));
                            }
                        })
                        .setNeutralButton("Student", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(view.getContext(), e_and_tc.class));

                            }
                        })
                        .show();

            }
        });

        binding.ITDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialAlertDialogBuilder(getContext(), R.style.AlertDialogTheme)
                        .setTitle("Select Category")
                        .setMessage("Select the following Option")
                        .setIcon(R.drawable.comp_dept)
                        .setPositiveButton("Teacher", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getContext(), ITTeacherActivity.class));
                            }
                        })
                        .setNeutralButton("Student", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(view.getContext(), IT.class));

                            }
                        })
                        .show();

            }
        });

        binding.pharmacyDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialAlertDialogBuilder(getContext(), R.style.AlertDialogTheme)
                        .setTitle("Select Category")
                        .setMessage("Select the following Option")
                        .setIcon(R.drawable.comp_dept)
                        .setPositiveButton("Teacher", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getContext(), PharmacyTeacherActivity.class));
                            }
                        })
                        .setNeutralButton("Student", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(view.getContext(), pharmacy.class));

                            }
                        })
                        .show();

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