package idat.apprestaurant.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import idat.apprestaurant.R;
import idat.apprestaurant.databinding.FragmentMenuBinding;
import idat.apprestaurant.ui.menu.fragment.AcompanamientosFragment;
import idat.apprestaurant.ui.menu.fragment.ArrocesFragment;
import idat.apprestaurant.ui.menu.fragment.BebidasFragment;
import idat.apprestaurant.ui.menu.fragment.CebichesFragment;
import idat.apprestaurant.ui.menu.fragment.CervezasFragment;
import idat.apprestaurant.ui.menu.fragment.CoctelesFragment;
import idat.apprestaurant.ui.menu.fragment.EspecialidadFragment;
import idat.apprestaurant.ui.menu.fragment.MakisFragment;
import idat.apprestaurant.ui.menu.fragment.NinosFragment;
import idat.apprestaurant.ui.menu.fragment.PastasRisottosFragment;
import idat.apprestaurant.ui.menu.fragment.PiqueosFragment;
import idat.apprestaurant.ui.menu.fragment.PromocionesFragment;
import idat.apprestaurant.ui.menu.fragment.SopasFragment;
import idat.apprestaurant.ui.menu.fragment.TiraditosFragment;

public class MenuFragment extends Fragment {

    private MenuViewModel menuViewModel;
    private FragmentMenuBinding binding;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PagerAdapter pagerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menuViewModel =
                new ViewModelProvider(this).get(MenuViewModel.class);

        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tabLayout = root.findViewById(R.id.TabPlatos);
        viewPager = root.findViewById(R.id.ViewPagerPlatos);

        tabLayout.addTab(tabLayout.newTab().setText("Promociones"));
        tabLayout.addTab(tabLayout.newTab().setText("Piqueos"));
        tabLayout.addTab(tabLayout.newTab().setText("Cebiches"));
        tabLayout.addTab(tabLayout.newTab().setText("Niños"));
        tabLayout.addTab(tabLayout.newTab().setText("Tiraditos"));
        tabLayout.addTab(tabLayout.newTab().setText("Makis"));
        tabLayout.addTab(tabLayout.newTab().setText("Sopas"));
        tabLayout.addTab(tabLayout.newTab().setText("Acompañamientos"));
        tabLayout.addTab(tabLayout.newTab().setText("Especialidad"));
        tabLayout.addTab(tabLayout.newTab().setText("Pastas/Risottos"));
        tabLayout.addTab(tabLayout.newTab().setText("Arroces"));
        tabLayout.addTab(tabLayout.newTab().setText("Bebidas"));
        tabLayout.addTab(tabLayout.newTab().setText("Tragos y Cocteles"));
        tabLayout.addTab(tabLayout.newTab().setText("Cervezas"));

        pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    public class PagerAdapter extends FragmentPagerAdapter{

        int numTabs;
        public PagerAdapter(@NonNull @NotNull FragmentManager fm, int numTabs) {
            super(fm);
            this.numTabs = numTabs;
        }

        @NonNull
        @NotNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0: fragment = new PromocionesFragment(); break;
                case 1: fragment = new PiqueosFragment(); break;
                case 2: fragment = new CebichesFragment(); break;
                case 3: fragment = new NinosFragment(); break;
                case 4: fragment = new TiraditosFragment(); break;
                case 5: fragment = new MakisFragment(); break;
                case 6: fragment = new SopasFragment(); break;
                case 7: fragment = new AcompanamientosFragment(); break;
                case 8: fragment = new EspecialidadFragment(); break;
                case 9: fragment = new PastasRisottosFragment(); break;
                case 10: fragment = new ArrocesFragment(); break;
                case 11: fragment = new BebidasFragment(); break;
                case 12: fragment = new CoctelesFragment(); break;
                case 13: fragment = new CervezasFragment(); break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return numTabs;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}