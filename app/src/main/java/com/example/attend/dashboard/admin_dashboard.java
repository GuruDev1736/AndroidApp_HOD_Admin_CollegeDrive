package com.example.attend.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.attend.Department.computer;
import com.example.attend.R;
import com.example.attend.add_teacher;
import com.example.attend.databinding.ActivityAdminDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;


public class admin_dashboard extends AppCompatActivity {

    private ActivityAdminDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdminDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), add_teacher.class));
            }
        });

        BottomNavigationView navView = findViewById(R.id.nav_view);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment_activity_main);
        NavController navController = navHostFragment.getNavController();
        //  NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        NavigationUI.setupWithNavController(binding.navView, navController);
    }


}