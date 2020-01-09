package com.hbc.depok.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.hbc.depok.R
import com.hbc.depok.view.ui.ArtikelFragment
import com.hbc.depok.view.ui.PengurusFragment
import com.hbc.depok.view.ui.listmember.MemberListFragment

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   supportFragmentManager.beginTransaction().replace(R.id.container, MemberListFragment()).commit()
        initViews()
        setStatePageAdapter()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                val count = fm.backStackEntryCount
                if (count >= 1) {
                    supportFragmentManager.popBackStack()
                }
                ft.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // setAdapter();
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

                //   viewPager.notifyAll();
            }
        })
    }

    private fun setStatePageAdapter(){
        val myViewPageStateAdapter = ViewPageStateAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(MemberListFragment(),"List Member")
        myViewPageStateAdapter.addFragment(PengurusFragment(),"Daftar Pengurus")
       myViewPageStateAdapter.addFragment(ArtikelFragment(),"Artikel")
        viewPager.adapter=myViewPageStateAdapter
        tabLayout.setupWithViewPager(viewPager,true)
    }

    private fun  initViews(){
        viewPager = findViewById(R.id.pager)
        tabLayout = findViewById(R.id.tabs)
    }

    class ViewPageStateAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){
        val fragmentList:MutableList<Fragment> = ArrayList()
        val fragmentTitleList:MutableList<String> = ArrayList()


        override fun getItem(position: Int): Fragment {
            return fragmentList.get(position)
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitleList.get(position)
        }

        fun addFragment(fragment: Fragment, title:String){
            fragmentList.add(fragment)
            fragmentTitleList.add(title)

        }
    }
}
