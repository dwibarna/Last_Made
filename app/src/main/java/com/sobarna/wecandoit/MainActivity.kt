package com.sobarna.wecandoit

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sobarna.wecandoit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var broadcastReceiver: BroadcastReceiver
    private lateinit var binding: ActivityMainBinding

    companion object{
        private val TAB_TITLES = intArrayOf(
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_favorite_white
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sectionAdapter()
    }
    private fun registerBroadCastReceiver() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                when (intent.action) {
                    Intent.ACTION_POWER_CONNECTED -> {
                        Toast.makeText(context, "connected", Toast.LENGTH_SHORT).show()
                        Log.d(context.toString(),"connected")
                    }
                    Intent.ACTION_POWER_DISCONNECTED -> {
                        Toast.makeText(context, "disconnected", Toast.LENGTH_SHORT).show()
                        Log.d(context.toString(),"disconnected")
                    }
                }
            }
        }
        val intentFilter = IntentFilter()
        intentFilter.apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(broadcastReceiver, intentFilter)
    }

    override fun onStart() {
        super.onStart()
        registerBroadCastReceiver()
    }
 //   override fun onStop() {
  //      super.onStop()
 //       unregisterReceiver(broadcastReceiver)
  //  }


    private fun sectionAdapter() {
        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager: ViewPager2 = binding.vpMain
        viewPager.adapter =sectionPagerAdapter
        val tabs: TabLayout =binding.tlMain
        TabLayoutMediator(tabs,viewPager){ tab,position ->
            tab.icon = resources.getDrawable(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.nav_dynamic){
            val uri = Uri.parse("wecandoit://dynamic")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

}